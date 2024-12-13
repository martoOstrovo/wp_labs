package mk.ukim.finki.wp.lab.web.controller;

import mk.ukim.finki.wp.lab.model.Artist;
import mk.ukim.finki.wp.lab.model.Song;
import mk.ukim.finki.wp.lab.service.ArtistService;
import mk.ukim.finki.wp.lab.service.SongService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/artists")
public class ArtistController {
    private final ArtistService artistService;
    private final SongService songService;

    public ArtistController(ArtistService artistService, SongService songService) {
        this.artistService = artistService;
        this.songService = songService;
    }

    @GetMapping
    public String getArtists(@RequestParam String trackId,  @RequestParam(required = false) String error ,Model model) {
        //TODO error message implementation
        if(error != null && !error.isEmpty()) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", error);
        }
        model.addAttribute("artists", artistService.listArtists());
        model.addAttribute("songID", trackId);
        return "artistsList";
    }

    @PostMapping
    public String artist(@RequestParam String trackId) {
        return "redirect:/artists?trackId=" + trackId;
    }

    @PostMapping("/add/{ID}")
    public String addArtist(@PathVariable String ID, @RequestParam Long artistId) {
        Song song = songService.findByTrackId(ID);
        Artist artist = artistService.findById(artistId);
        try {
            songService.addArtistToSong(artist, song);
            artistService.addSongToArtist(artist, song);
        } catch (RuntimeException e) {
            return "redirect:/artists?trackId=" + ID + "&error=" + "Failed to add artist to song: " + e.getMessage();
        }
        return "redirect:/artists/details?trackId=" + ID;
    }

    @GetMapping("/details")
    public String getSongDetails(@RequestParam String trackId, Model model) {
        model.addAttribute("selectedSong", songService.findByTrackId(trackId));
        return "songDetails";
    }
}

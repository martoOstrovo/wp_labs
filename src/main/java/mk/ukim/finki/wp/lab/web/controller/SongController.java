package mk.ukim.finki.wp.lab.web.controller;

import mk.ukim.finki.wp.lab.model.Album;
import mk.ukim.finki.wp.lab.service.AlbumService;
import mk.ukim.finki.wp.lab.service.Implementation.SongServiceImplementation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/songs")
public class SongController {
    private final SongServiceImplementation songService;
    private final AlbumService albumService;

    public SongController(SongServiceImplementation songService, AlbumService albumService) {
        this.songService = songService;
        this.albumService = albumService;
    }

    @GetMapping
    public String getSongsPage(@RequestParam(required = false) String error, Model model) {
        if(error != null && !error.isEmpty()) {
            model.addAttribute("error", error);
            model.addAttribute("hasError", true);
        }
        model.addAttribute("songs", songService.listSongs());
        return "listSongs";
    }


    @GetMapping("/add-form")
    public String getAddSongPage(Model model) {
        model.addAttribute("albums", albumService.findAll());
        return "add-song";
    }



    @PostMapping("/add")
    public String saveSong(@RequestParam String trackId,
                           @RequestParam String title,
                           @RequestParam String genre,
                           @RequestParam int releaseYear,
                           @RequestParam Long albumID) {
        if(albumService.findById(albumID).isPresent()) {
            Album album = albumService.findById(albumID).get();
            songService.saveSong(trackId, title, genre, releaseYear, album);
            return "redirect:/songs";
        } else {
            return "redirect:/songs?error=albumNotFound";
        }
    }

    @GetMapping("/edit/{id}")
    public String editSong(@PathVariable Long id, Model model) {
        if(songService.findById(id).isPresent()) {
            model.addAttribute("song", songService.findById(id).get());
            model.addAttribute("albums", albumService.findAll());
            return "add-song";
        } else {
            return "redirect:/songs?error=songNotFound";
        }
    }

    @GetMapping("/delete/{id}")
    public String deleteSong(@PathVariable Long id) {
        if(songService.findById(id).isPresent()) {
            songService.deleteByID(id);
            return "redirect:/songs";
        } else {
            return "redirect:/songs?error=songNotFound";
        }
    }

}

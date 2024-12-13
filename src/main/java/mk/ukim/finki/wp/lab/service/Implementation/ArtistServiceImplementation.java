package mk.ukim.finki.wp.lab.service.Implementation;

import mk.ukim.finki.wp.lab.model.Artist;
import mk.ukim.finki.wp.lab.model.Song;
import mk.ukim.finki.wp.lab.repository.jpa.ArtistRepository;
import mk.ukim.finki.wp.lab.service.ArtistService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArtistServiceImplementation implements ArtistService {
    private final ArtistRepository artistRepository;

    public ArtistServiceImplementation(ArtistRepository artistRepository) {
        this.artistRepository = artistRepository;
    }


    @Override
    public void save(Artist artist) {
        artistRepository.save(artist);
    }

    @Override
    public List<Artist> listArtists() {
        return artistRepository.findAll();
    }

    @Override
    public Artist findById(Long id) {
        if(id == null) {
            throw new IllegalArgumentException("ID cannot be null");
        }
        Optional<Artist> artist = artistRepository.findByID(id);
        if (artist.isPresent()) {
            return artist.get();
        } else {
            throw new RuntimeException("Artist not found");
        }
    }

    @Override
    public Song addSongToArtist(Artist artist, Song song) {
        if(song == null  || artist == null) throw new RuntimeException("Artist or Song cannot be null");
        if(artist.getSongs().stream().anyMatch(s -> s.getID().equals(song.getID()))) {
            throw new RuntimeException("Artist already has song " + song.getTitle());
        }
        artist.getSongs().add(song);
        artistRepository.save(artist);
        return song;
    }
}

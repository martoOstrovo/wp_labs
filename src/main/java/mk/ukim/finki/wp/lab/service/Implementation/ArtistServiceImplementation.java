package mk.ukim.finki.wp.lab.service.Implementation;

import mk.ukim.finki.wp.lab.model.Artist;
import mk.ukim.finki.wp.lab.repository.ArtistRepository;
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
    public List<Artist> listArtists() {
        return artistRepository.findAll();
    }

    @Override
    public Artist findById(Long id) {
        if(id == null) {
            throw new IllegalArgumentException("ID cannot be null");
        }
        Optional<Artist> artist = artistRepository.findById(id);
        if (artist.isPresent()) {
            return artist.get();
        } else {
            throw new RuntimeException("Artist not found");
        }
    }
}

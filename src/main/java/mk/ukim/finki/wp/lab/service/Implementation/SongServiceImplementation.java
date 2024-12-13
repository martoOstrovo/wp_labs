package mk.ukim.finki.wp.lab.service.Implementation;

import jakarta.transaction.Transactional;
import mk.ukim.finki.wp.lab.model.Album;
import mk.ukim.finki.wp.lab.model.Artist;
import mk.ukim.finki.wp.lab.model.Song;
import mk.ukim.finki.wp.lab.model.exceptions.NoSongTitleMatchesSearchException;
import mk.ukim.finki.wp.lab.repository.jpa.SongRepository;
import mk.ukim.finki.wp.lab.service.SongService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SongServiceImplementation implements SongService {
    private final SongRepository repository;

    public SongServiceImplementation(SongRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Song> listSongs() {
        return repository.findAll();
    }

    @Override
    public Artist addArtistToSong(Artist artist, Song song) {
        if(song == null  || artist == null) throw new RuntimeException("Artist or Song cannot be null");
        if(song.getPerformers().stream().anyMatch(per -> per.getID().equals(artist.getID()))) {
            throw new RuntimeException("Song already has performer " + artist.getFirstName() + " " + artist.getLastName());
        }
        song.getPerformers().add(artist);
        repository.save(song);
        return artist;
    }


    @Override
    public Song findByTrackId(String trackId) {
        if (trackId == null || trackId.isEmpty()) {
            throw new IllegalArgumentException("Track ID cannot be null or empty");
        }
        return repository.findByTrackId(trackId);
    }

    @Override
    public List<Song> findBySearchString(String searchString) {
        List<Song> songs = repository.findAllByTitleLike(searchString);
        if(songs == null || songs.isEmpty()) {
            throw new NoSongTitleMatchesSearchException(searchString);
        }
        return songs;
    }

    @Override
    @Transactional
    public Song saveSong(String trackId, String title, String genre, int releaseYear, Album album) {
        repository.deleteByTrackId(trackId);
        return repository.save(new Song(trackId,title,genre, releaseYear, new ArrayList<>(), album));
    }

    @Override
    @Transactional
    public void deleteByID(Long id) {
        repository.deleteByID(id);
    }

    @Override
    public Optional<Song> findById(Long ID) {
        return repository.findById(ID);
    }
}

package mk.ukim.finki.wp.lab.repository;

import mk.ukim.finki.wp.lab.bootstrap.DataHolder;
import mk.ukim.finki.wp.lab.model.Artist;
import mk.ukim.finki.wp.lab.model.Song;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class SongRepository {

    public Song save(Song song) {
        DataHolder.tracks.removeIf(s -> s.getTitle().equals(song.getTitle()));
        DataHolder.tracks.add(song);
        return song;
    }

    public List<Song> findAll() {
        return DataHolder.tracks;
    }

    public Song findByTrackId(String trackId) {
        return DataHolder.tracks.stream()
                .filter(x -> x.getTrackId().equals(trackId))
                .findFirst()
                .orElse(null);
    }

    @SuppressWarnings("OptionalGetWithoutIsPresent")
    public Artist addArtistToSong(Artist artist, Song song) {
        DataHolder.tracks.stream()
                .filter(s -> s.equals(song))
                .findFirst()
                .get()
                .getPerformers()
                .add(artist);
        return artist;
    }

    public List<Song> findBySearchString(String searchString) {
        return DataHolder.tracks.stream()
                .filter(track -> track.getTitle().toLowerCase().contains(searchString.toLowerCase()))
                .collect(Collectors.toList());
    }

    public Optional<Song> findById(Long ID) {
        return DataHolder.tracks.stream()
                .filter(x -> x.getID().equals(ID))
                .findFirst();
    }

    public void deleteByID(Long id) {
        DataHolder.tracks.removeIf(track -> track.getID().equals(id));
    }
}

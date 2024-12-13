package mk.ukim.finki.wp.lab.service;

import mk.ukim.finki.wp.lab.model.Artist;
import mk.ukim.finki.wp.lab.model.Song;

import java.util.List;

public interface ArtistService{
    void save(Artist artist);
    List<Artist> listArtists();
    Artist findById(Long id);
    Song addSongToArtist(Artist artist, Song song);
}

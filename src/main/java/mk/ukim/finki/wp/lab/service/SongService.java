package mk.ukim.finki.wp.lab.service;

import mk.ukim.finki.wp.lab.model.Album;
import mk.ukim.finki.wp.lab.model.Artist;
import mk.ukim.finki.wp.lab.model.Song;

import java.util.List;
import java.util.Optional;

public interface SongService{
    List<Song> listSongs();
    Artist addArtistToSong(Artist artist, Song song);
    public Song findByTrackId(String trackId);
    List<Song> findBySearchString(String searchString);
    public Song saveSong(String trackId, String title, String genre, int releaseYear, Album album);
    public void deleteByID(Long id);
    Optional<Song> findById(Long ID);
}
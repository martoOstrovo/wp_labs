package mk.ukim.finki.wp.lab.bootstrap;

import jakarta.annotation.PostConstruct;
import mk.ukim.finki.wp.lab.model.Album;
import mk.ukim.finki.wp.lab.model.Artist;
import mk.ukim.finki.wp.lab.model.Song;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {
    public static List<Artist> artists = new ArrayList<>();
    public static List<Song> tracks = new ArrayList<>();
    public static List<Album> albums = new ArrayList<>();

    @PostConstruct
    public void init() {
        artists.add(new Artist(210L,"Bob", "Bobovski" ,"test1"));
        artists.add(new Artist(220L,"Bobi", "Galic", "test2"));
        artists.add(new Artist(230L,"Teo", "Eftimov", "test3"));
        artists.add(new Artist(240L,"Nemanja", "Jokic", "test4"));
        artists.add(new Artist(250L,"David", "Ivanovski", "test5"));

        Album a1=new Album("Thriller", "Pop", "1982");
        Album a2=new Album("Back in Black", "Rock", "1980");
        Album a3=new Album("The Dark Side of the Moon", "Progressive Rock", "1973");
        Album a4=new Album("1989", "Pop", "2014");
        Album a5=new Album("Nevermind", "Grunge", "1991");

        albums.add(a1);
        albums.add(a2);
        albums.add(a3);
        albums.add(a4);
        albums.add(a5);

        tracks.add(new Song("T001", "Midnight Echo", "Jazz", 2019,new ArrayList<>(),a1));
        tracks.add(new Song("T002", "Sunset Drive", "Synthwave", 2021,new ArrayList<>(),a2));
        tracks.add(new Song("T003", "Dreamscape", "Electronic", 2020,new ArrayList<>(),a3));
        tracks.add(new Song("T004", "Dream", "Electronic", 2020,new ArrayList<>(),a4));
        tracks.add(new Song("T005", "Mountain Whispers", "Folk", 2025,new ArrayList<>(),a5));
    }
}

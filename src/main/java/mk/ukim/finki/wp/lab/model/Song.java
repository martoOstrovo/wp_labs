package mk.ukim.finki.wp.lab.model;
import jakarta.persistence.*;
import lombok.Data;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;
    private String trackId;
    private String title;
    private String genre;
    private int releaseYear;
    @ManyToMany
    private List<Artist> performers;
    @ManyToOne
    private Album album;

    public Song(String trackId, String title, String genre, int releaseYear, List<Artist> performers, Album album) {
        this.trackId = trackId;
        this.title = title;
        this.genre = genre;
        this.releaseYear = releaseYear;
        this.performers = performers;
        this.album = album;
    }

    public Song() {
        performers = new ArrayList<>();
    }

}

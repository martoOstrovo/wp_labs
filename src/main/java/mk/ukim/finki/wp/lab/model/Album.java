package mk.ukim.finki.wp.lab.model;

import lombok.Data;

@Data
public class Album {
    private Long ID;
    private String name;
    private String genre;
    private String releaseYear;

    public Album(String name, String genre, String releaseYear) {
        ID = (long)(Math.random()*1000);
        this.name = name;
        this.genre = genre;
        this.releaseYear = releaseYear;
    }
}

package mk.ukim.finki.wp.lab.model.exceptions;

public class NoSongTitleMatchesSearchException extends RuntimeException {
    public NoSongTitleMatchesSearchException(String searchString) {
        super(String.format("No song title matches search string: %s", searchString));
    }
}

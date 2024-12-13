package mk.ukim.finki.wp.lab.repository.jpa;

import mk.ukim.finki.wp.lab.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface SongRepository extends JpaRepository<Song, Long> {
    Song findByTrackId(String trackId);
    List<Song> findAllByTitleLike(String searchString);
    void deleteByID(Long id);
    void deleteByTrackId(String trackId);
}

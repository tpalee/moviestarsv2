package nl.moviestarsv2.repository;
import nl.moviestarsv2.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Collection;

public interface MovieRepository extends JpaRepository<Movie, Long> {

    public Collection<Movie> findAllByMovieTitle(String name);

}

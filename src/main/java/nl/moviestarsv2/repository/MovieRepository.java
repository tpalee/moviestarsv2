package nl.moviestarsv2.repository;
import nl.moviestarsv2.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

    public Collection<Movie> findAllByMovieTitle(String name);

}

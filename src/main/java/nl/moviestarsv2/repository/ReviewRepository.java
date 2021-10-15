package nl.moviestarsv2.repository;
import nl.moviestarsv2.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;


public interface ReviewRepository extends JpaRepository<Review, Long> {
   /* List<Review> findAllByMovie(Movie movie);*/

}

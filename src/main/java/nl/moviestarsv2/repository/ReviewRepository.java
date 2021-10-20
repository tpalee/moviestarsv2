package nl.moviestarsv2.repository;
import nl.moviestarsv2.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
   /* List<Review> findAllByMovie(Movie movie);*/

}

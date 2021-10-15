package nl.moviestarsv2.repository;
import nl.moviestarsv2.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Collection;

public interface UserRepository extends JpaRepository <User, Long>{

    public Collection<User>findAllByUsername(String name);
}

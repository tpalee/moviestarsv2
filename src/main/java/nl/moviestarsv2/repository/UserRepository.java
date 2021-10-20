package nl.moviestarsv2.repository;
import nl.moviestarsv2.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface UserRepository extends JpaRepository <User, String>{

    public Collection<User>findAllByUsername(String name);

}

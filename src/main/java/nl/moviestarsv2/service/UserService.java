package nl.moviestarsv2.service;

import nl.moviestarsv2.exceptions.IdAlreadyExistException;
import nl.moviestarsv2.exceptions.RecordNotFoundException;
import nl.moviestarsv2.model.Movie;
import nl.moviestarsv2.model.User;
import nl.moviestarsv2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;


    //constructor
    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    //get all users or search for a user
    public Collection<User> getUsers(String username) {
        if (username.isEmpty()) {
            return userRepository.findAll();
        }
        else{
            return userRepository.findAllByUsername(username);
        }
    }



    //create a new user
    public String createUser(User user) {
        User newUser = userRepository.save(user);
        return newUser.getUsername();
    }


    //update an existing user
    public void updateUser(String id, User newUser) {
        if (!userRepository.existsById(id)) throw new RecordNotFoundException();
        User user = userRepository.findById(id).get();
        user.setUsername(newUser.getUsername());
        user.setPassword(newUser.getPassword());
        user.setEmail(newUser.getEmail());
        userRepository.save(user);
    }


    //delete a user by id
    public void deleteUser(String id) {
        if (!userRepository.existsById(id)) throw new RecordNotFoundException();
        userRepository.deleteById(id);
    }



    //find a user by id
    public Optional<User> getUserById(String id) {
        if (!userRepository.existsById(id)) throw new RecordNotFoundException();
        return userRepository.findById(id);
    }


}

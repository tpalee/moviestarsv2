package nl.moviestarsv2.controller;

import nl.moviestarsv2.model.Movie;
import nl.moviestarsv2.model.User;
import nl.moviestarsv2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService userService;


    //get all users
    @GetMapping(value = "")
    public ResponseEntity<Object> searchUsers(@RequestParam(name="username", defaultValue = "") String name) {
        return ResponseEntity.ok().body(userService.getUsers(name));
    }


    //get one user
    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<User>> getUser(@PathVariable("id") String id) {
        return ResponseEntity.ok().body(userService.getUserById(id));
    }


    //create a new user
    @PostMapping(value = "")
    public ResponseEntity<Object> createUser(@RequestBody User user) {
       String newId = userService.createUser(user);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(newId).toUri();

        return ResponseEntity.ok("Created").created(location).build();
    }

    //update an existing user
    @PutMapping(value = "/{id}")
    public ResponseEntity<Object> updateUser(@PathVariable("id") String id, @RequestBody User user) {
        userService.updateUser(id, user);
        return ResponseEntity.noContent().build();
    }

    //delete a user
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> deleteUser(@PathVariable("id") String id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

}
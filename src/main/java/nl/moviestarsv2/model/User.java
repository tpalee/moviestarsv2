package nl.moviestarsv2.model;


import javax.persistence.*;

@Entity
@Table(name="users")
public class User {

    @Id
    @Column(nullable = false, unique = true)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "email")
    private String email;

    @Column()
    private boolean enabled = true;


    ////////////////
    //CONSTRUCTORS//
    ////////////////


    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User() {
    }



    //////////////////////
    //GETTERS AN SETTERS//
    //////////////////////


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
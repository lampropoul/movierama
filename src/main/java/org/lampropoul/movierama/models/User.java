package org.lampropoul.movierama.models;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "user", schema = "public")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column
    @NotEmpty(message = "Provide username")
    private String username;

    @Column
    @NotEmpty(message = "Provide name")
    private String name;

    @Column
    @NotEmpty(message = "Provide surname")
    private String surname;

    @Column
    @NotEmpty(message = "Provide email")
    private String email;

    @Column
    @NotEmpty(message = "Provide password")
    private String password;

    @Transient
    @JoinTable(
            name = "vote",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "movie_id")})
    private Set<Movie> moviesVoted = new HashSet<>();

    @Transient
    @ManyToOne(targetEntity = Movie.class)
    private Set<Movie> moviesAdded = new HashSet<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Movie> getMoviesVoted() {
        return moviesVoted;
    }

    public Set<Movie> getMoviesAdded() {
        return moviesAdded;
    }
}

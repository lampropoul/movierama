package org.lampropoul.movierama.models;

import javax.persistence.*;

@Entity
@Table(name = "vote")
@SecondaryTables({
        @SecondaryTable(name = "movie"), @SecondaryTable(name = "user")
})
public class Vote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "movie_id", referencedColumnName = "id", table = "movie", nullable = false)
    private Movie movie;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", referencedColumnName = "id", table = "user", nullable = false)
    private User user;

    @Column(name = "is_like")
    private boolean isLike;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean isLike() {
        return isLike;
    }

    public void setLike(boolean like) {
        isLike = like;
    }
}

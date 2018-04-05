package org.lampropoul.movierama.models;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "movie")
@SecondaryTable(name = "user")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column
    @NotEmpty(message = "Provide title")
    private String title;

    @Column
    @NotEmpty(message = "Provide description")
    private String description;

    @Column(name = "date_published")
    private Date date;

    @Column(name = "added_by")
    private int addedBy;

    @Transient
    @JoinTable(
            name = "vote",
            joinColumns = {@JoinColumn(name = "movie_id")},
            inverseJoinColumns = {@JoinColumn(name = "user_id")})
    private Set<User> userVoted = new HashSet<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getAddedBy() {
        return addedBy;
    }

    public void setAddedBy(int addedBy) {
        this.addedBy = addedBy;
    }

    public Set<User> getUserVoted() {
        return userVoted;
    }
}

package org.lampropoul.movierama.repositories;

import org.lampropoul.movierama.models.Movie;
import org.lampropoul.movierama.models.User;
import org.lampropoul.movierama.models.Vote;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository("voteRepository")
public interface VoteRepository extends CrudRepository<Vote, Long> {
    Vote findByMovie(Movie movie);

    Vote findByUser(User user);

    Set<User> findAllByMovie(Movie movie);

    Set<Movie> findAllByUser(User user);
}

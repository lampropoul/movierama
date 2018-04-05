package org.lampropoul.movierama.repositories;

import org.lampropoul.movierama.models.Movie;
import org.lampropoul.movierama.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository("movieRepository")
public interface MovieRepository extends CrudRepository<Movie, Long> {
    Movie findByTitle(String title);
}

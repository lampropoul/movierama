package org.lampropoul.movierama.repositories;

import org.lampropoul.movierama.models.Movie;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("movieRepository")
public interface MovieRepository extends CrudRepository<Movie, Long> {
    Movie findByTitle(String title);
}

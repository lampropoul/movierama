package org.lampropoul.movierama.services;

import org.lampropoul.movierama.models.Movie;
import org.lampropoul.movierama.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("movieService")
public class MovieService {

    private MovieRepository movieRepository;

    @Autowired
    public MovieService(@Qualifier("movieRepository") MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public Movie findByTitle(String title) {
        return movieRepository.findByTitle(title);
    }

    public void saveMovie(Movie movie) {
        movieRepository.save(movie);
    }
}

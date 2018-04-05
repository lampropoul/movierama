package org.lampropoul.movierama.controllers;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.lampropoul.movierama.models.Movie;
import org.lampropoul.movierama.models.User;
import org.lampropoul.movierama.services.MovieService;
import org.lampropoul.movierama.services.UserService;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.Mockito.mock;

@RunWith(SpringRunner.class)
@WebMvcTest(RegisterController.class)
public class MovieControllerTest {

    @Autowired
    private MovieService movieService;
    @Autowired
    private UserService userService;

    private MovieController movieController;

    @Configuration
    static class Config {
        @Bean
        public MovieService getMovieService() {
            return mock(MovieService.class);
        }

        @Bean
        public UserService getUserService() {
            return mock(UserService.class);
        }
    }

    @Test
    public void shouldSaveMovieToDatabase() {
        movieController = new MovieController(movieService, userService);
        Movie movie = new Movie();
        User loggedInUser = new User();
        loggedInUser.setId(1);
        movie.setTitle("Star Wars Episode VII: The Last Jedi");
        Mockito
                .when(movieController.addMovie(movie, loggedInUser))
                .thenReturn(movie);
        Assert.assertEquals(movie.getTitle(), "Star Wars Episode VII: The Last Jedi");
    }
}
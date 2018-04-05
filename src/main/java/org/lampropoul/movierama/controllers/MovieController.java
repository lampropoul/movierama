package org.lampropoul.movierama.controllers;

import org.lampropoul.movierama.models.Movie;
import org.lampropoul.movierama.models.User;
import org.lampropoul.movierama.services.MovieService;
import org.lampropoul.movierama.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class MovieController {
    private final MovieService movieService;
    private final UserService userService;

    @Autowired
    public MovieController(MovieService movieService, UserService userService) {
        this.movieService = movieService;
        this.userService = userService;
    }

    @GetMapping("/movie/new")
    public ModelAndView show(ModelAndView modelAndView, Movie movie) {
        modelAndView.addObject("movie", movie);
        modelAndView.setViewName("movie");
        return modelAndView;
    }

    @PostMapping("/movie/new")
    public Movie addMovie(@Valid Movie movie, User loggedInUser) {
        if (loggedInUser == null || loggedInUser.getId() == 0) {
            loggedInUser = userService.findByUsername("vlamp");
        }
        movie.setAddedBy(loggedInUser.getId());
        return movieService.saveMovie(movie);
    }
}

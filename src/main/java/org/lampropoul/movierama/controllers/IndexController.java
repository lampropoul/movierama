package org.lampropoul.movierama.controllers;

import org.lampropoul.movierama.services.MovieService;
import org.lampropoul.movierama.services.UserService;
import org.lampropoul.movierama.services.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    private final VoteService voteService;
    private final MovieService movieService;
    private final UserService userService;

    @Autowired
    public IndexController(VoteService voteService, MovieService movieService, UserService userService) {
        this.voteService = voteService;
        this.movieService = movieService;
        this.userService = userService;
    }

    @GetMapping("/")
    public String show() {
        return "index";
    }
}

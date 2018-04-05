package org.lampropoul.movierama.controllers;

import org.lampropoul.movierama.services.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    private final VoteService voteService;

    @Autowired
    public IndexController(VoteService voteService) {
        this.voteService = voteService;
    }

    @GetMapping("/")
    public String show() {
        return "index";
    }
}

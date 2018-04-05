package org.lampropoul.movierama.services;

import org.lampropoul.movierama.models.Movie;
import org.lampropoul.movierama.models.User;
import org.lampropoul.movierama.models.Vote;
import org.lampropoul.movierama.repositories.UserRepository;
import org.lampropoul.movierama.repositories.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("voteService")
public class VoteService {

    private VoteRepository voteRepository;

    @Autowired
    public VoteService(@Qualifier("voteRepository") VoteRepository voteRepository) {
        this.voteRepository = voteRepository;
    }

    public Vote findByMovie(Movie movie) {
        return voteRepository.findByMovie(movie);
    }

    public Vote findByUser(User user) {
        return voteRepository.findByUser(user);
    }

    public void saveVote(Vote vote) {
        voteRepository.save(vote);
    }
}

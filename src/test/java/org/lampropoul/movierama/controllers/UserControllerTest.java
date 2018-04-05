package org.lampropoul.movierama.controllers;

import org.junit.Test;
import org.lampropoul.movierama.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

public class UserControllerTest {

    @Autowired
    private UserService userService;

    private UserController userController;

    @Configuration
    static class Config {
        @Bean
        public UserService getUserService() {
            return mock(UserService.class);
        }
    }

    @Test
    public void renderUserPage() {
        userController = new UserController(userService);
        String page = userController.show("vlamp");
        if ("user".equals(page)) {
            assert true;
            return;
        }
        assert false;
    }
}
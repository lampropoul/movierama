package org.lampropoul.movierama.controllers;

import com.google.gson.Gson;
import org.lampropoul.movierama.models.User;
import org.lampropoul.movierama.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class RegisterController {

    private UserService userService;

    @Autowired
    public RegisterController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String renderRegistrationPage() {
        return "register";
    }

    @PostMapping("/register")
    public User register(@RequestBody String requestBody) {
        User user = new Gson().fromJson(requestBody, User.class);
        return userService.saveUser(user);
    }
}

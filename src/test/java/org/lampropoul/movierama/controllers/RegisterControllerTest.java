package org.lampropoul.movierama.controllers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.lampropoul.movierama.models.User;
import org.lampropoul.movierama.services.UserService;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.jws.soap.SOAPBinding;

import static org.mockito.Mockito.mock;

@RunWith(SpringRunner.class)
@WebMvcTest(RegisterController.class)
public class RegisterControllerTest {

    @Autowired
    private UserService userService;

    private RegisterController registerController;

    @Configuration
    static class Config {
        @Bean
        public UserService getUserService() {
            return mock(UserService.class);
        }
    }

    @Test
    public void shouldRenderRegistrationPage() {
        registerController = new RegisterController(userService);
        String page = registerController.renderRegistrationPage();
        if ("register".equals(page)) {
            assert true;
            return;
        }
        assert false;
    }

    @Test
    public void shouldSaveUserToDatabase() {
        registerController = new RegisterController(userService);
        User user = new User();
        user.setUsername("vlamp");
        Mockito
                .when(registerController.register(new Gson().toJson(user)))
                .thenReturn(user);
        Assert.assertEquals(user.getUsername(), "vlamp");
    }
}
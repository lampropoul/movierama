package org.lampropoul.movierama;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class MovieramaApplication {

    public static void main(String[] args) {
        SpringApplication.run(MovieramaApplication.class, args);
    }
}

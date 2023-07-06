package com.example.day73;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class Day73Application {

    public static void main(String[] args) {
        SpringApplication.run(Day73Application.class, args);
    }

}

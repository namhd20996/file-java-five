package com.example.email;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SpringEmailLearningApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringEmailLearningApplication.class, args);
    }

}

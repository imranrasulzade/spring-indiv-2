package com.example.springindiv2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SpringIndiv2Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringIndiv2Application.class, args);
    }

}

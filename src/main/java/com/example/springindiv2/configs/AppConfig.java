package com.example.springindiv2.configs;

import com.example.springindiv2.model.Test;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppConfig {

    @Bean
    @Scope(value = "singleton")
    public Test test() {
        return new Test();
    }

}

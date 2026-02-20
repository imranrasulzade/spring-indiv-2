package com.example.springindiv2.controller;

import com.example.springindiv2.model.Test;

import com.example.springindiv2.service.TestService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tests")
public class TestController {

    private final TestService testService;

    public TestController(TestService testService) {
        this.testService = testService;
    }


    // GET POST PUT PATCH DELETE

    @GetMapping("/hello")
    public String hello() {
        return "hello Said";
    }

    @GetMapping("/hii")
    public String hii() {
        return "hello Imran";
    }

    @Tag(name = "addr")
    @GetMapping
    public String hii2() {
        return "hello 2";
    }
}

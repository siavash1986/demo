package com.example.demo;

import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;

@RestController
public class HelloWorldController {

    private Instant startupInstant;
    private LocalDateTime startupDateTime;


    public HelloWorldController(Environment environment){
        startupInstant = Instant.now();
        startupDateTime = LocalDateTime.now();
    }

    @GetMapping("/hello")
    @ResponseStatus(HttpStatus.OK)
    public String helloWorld(){
        return "Hello World!";
    }

    @GetMapping("/uptime")
    @ResponseStatus(HttpStatus.OK)
    public String upTime(){
        return "UPTIME: " + Duration.between(startupInstant, Instant.now()) +
                System.lineSeparator() + "DATETIME: " + startupDateTime;
    }
}

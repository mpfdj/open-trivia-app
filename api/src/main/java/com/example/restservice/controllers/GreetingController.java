package com.example.restservice.controllers;

import com.example.restservice.model.api.Greeting;
import com.example.restservice.services.OpenTriviaSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @Autowired
    private OpenTriviaSearchService openTriviaSearchService;

    @GetMapping("/test-es-get-a-doc")
    public void testES() {
        openTriviaSearchService.testESGetADoc();
    }

    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }
}
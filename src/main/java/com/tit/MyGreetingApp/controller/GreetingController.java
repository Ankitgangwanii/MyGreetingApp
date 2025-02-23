package com.tit.MyGreetingApp.controller;


import com.tit.MyGreetingApp.service.GreetingService;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/greeting")
public class GreetingController {

    private final GreetingService greetingService;

    public GreetingController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    // Default GET mapping for /greeting
    @GetMapping
    public Map<String, String> defaultGreeting() {
        Map<String, String> response = new HashMap<>();
        response.put("message", "Welcome to the Greeting App!");
        return response;
    }

    @GetMapping("/get")
    public Map<String, String> getGreeting() {
        return greetingService.getGreeting();
    }

    @PostMapping("/post")
    public Map<String, String> createGreeting(@RequestBody Map<String, String> request) {
        Map<String, String> response = new HashMap<>();
        response.put("message", "POST request received.");
        response.put("data", request.getOrDefault("name", "No name provided"));
        return response;
    }

    @PutMapping("/put")
    public Map<String, String> updateGreeting(@RequestBody Map<String, String> request) {
        Map<String, String> response = new HashMap<>();
        response.put("message", "PUT request received.");
        response.put("data", request.getOrDefault("name", "No name provided"));
        return response;
    }

    @DeleteMapping("/delete")
    public Map<String, String> deleteGreeting() {
        Map<String, String> response = new HashMap<>();
        response.put("message", "DELETE request received.");
        return response;
    }
}
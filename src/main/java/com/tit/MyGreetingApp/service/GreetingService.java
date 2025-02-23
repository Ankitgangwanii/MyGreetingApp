package com.tit.MyGreetingApp.service;

import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;

@Service
public class GreetingService {

    public Map<String, String> getGreeting(Map<String, String> request) {
        Map<String, String> response = new HashMap<>();
        String firstName = request.getOrDefault("firstName", "").trim();
        String lastName = request.getOrDefault("lastName", "").trim();

        String greetingMessage;
        if (!firstName.isEmpty() && !lastName.isEmpty()) {
            // Both firstName and lastName are provided
            greetingMessage = "Hello " + firstName + " " + lastName + "!";
        } else if (!firstName.isEmpty()) {
            // Only firstName is provided
            greetingMessage = "Hello " + firstName + "!";
        } else if (!lastName.isEmpty()) {
            // Only lastName is provided
            greetingMessage = "Hello " + lastName + "!";
        } else {
            // Neither firstName nor lastName is provided
            greetingMessage = "Hello World!";
        }

        response.put("message", greetingMessage);
        return response;
    }
}
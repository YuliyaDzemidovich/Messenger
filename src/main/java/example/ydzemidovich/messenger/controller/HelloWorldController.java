package example.ydzemidovich.messenger.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Example of a REST controller in Spring Boot
 */
@RestController
@RequestMapping("/api/v1")
public class HelloWorldController {

    /**
     * Example of a REST-endpoint
     * @return greeting string
     */
    @GetMapping("/hello")
    public String getGreeting() {
        return "Hello World from Spring Boot application!";
    }
}

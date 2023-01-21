package example.ydzemidovich.messenger.controller;

import example.ydzemidovich.messenger.entity.User;
import example.ydzemidovich.messenger.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

import static example.ydzemidovich.messenger.Constants.API_VERSION;

/**
 * Example of a REST controller in Spring Boot
 */
@RestController
@RequestMapping(API_VERSION)
@RequiredArgsConstructor
public class HelloWorldController {

    private final UserRepo userRepo;

    /**
     * Example of a REST-endpoint
     * Greets user by his/her name. Currently logged user is provided by Spring Security as Principal object.
     * @return greeting string
     */
    @GetMapping("/hello")
    public String getGreeting(Principal principal) {
        User user = userRepo.findUserByLogin(principal.getName());
        if (user == null) {
            return "Hello World from Spring Boot application!";
        }
        return "Hello " + user.getFirstName() + " " + user.getLastName() + " from Spring Boot application!";
    }
}

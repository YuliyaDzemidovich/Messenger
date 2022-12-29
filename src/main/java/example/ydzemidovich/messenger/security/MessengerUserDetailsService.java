package example.ydzemidovich.messenger.security;

import example.ydzemidovich.messenger.entity.User;
import example.ydzemidovich.messenger.repository.UserRepo;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Implementation of Spring's Security UserDetailsService for the Messenger application.
 */
@Service
@AllArgsConstructor
public class MessengerUserDetailsService implements UserDetailsService {

    private static final String MESSAGE_USER_NOT_FOUND = "Requested user not found or does not exist";

    private final UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (username == null) {
            throw new UsernameNotFoundException(MESSAGE_USER_NOT_FOUND);
        }
        User user = userRepo.findUserByLogin(username);
        if (user == null) {
            throw new UsernameNotFoundException(MESSAGE_USER_NOT_FOUND);
        }
        return new SecurityUser(user);
    }
}

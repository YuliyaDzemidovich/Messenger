package example.ydzemidovich.messenger.security;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SecurityConfigTest {

    @Autowired
    PasswordEncoder passwordEncoder;

    /**
     * Encodes (calculates hash) for the given string with default password encoder for this application.
     * This is the way passwords should be stored in the database.
     */
    @Test
    void passwordEncoder() {
        String password = "12345";
        String hashedPassword = passwordEncoder.encode(password);
        System.out.println(hashedPassword);
        // default hashing algorithm in DelegatingPasswordEncoder is BCrypt
        assertTrue(hashedPassword.startsWith("{bcrypt}"));
    }
}

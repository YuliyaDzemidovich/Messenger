package example.ydzemidovich.messenger.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Spring Security configuration class.
 */
@Configuration
public class SecurityConfig {

    /**
     * Defines Password Encoder Bean - the way how user password should be encoded/hashed when it is stored in the database.
     * @return a specific type of Password Encoder
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }
}

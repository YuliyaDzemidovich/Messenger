package example.ydzemidovich.messenger.config;

import example.ydzemidovich.messenger.security.CustomAuthenticationSuccessHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;


/**
 * Spring Security configuration class.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    /**
     * Defines Password Encoder Bean - the way how user password should be encoded/hashed when it is stored in the database.
     * @return a specific type of Password Encoder
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    /**
     * Configure Spring Security
     * @param http HttpSecurity object
     * @return SecurityFilterChain
     * @throws Exception security configuration exception
     */
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf()
            .disable()
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/js/main.js").permitAll()
                .requestMatchers("/css/main.css").permitAll()
                .anyRequest().authenticated()
            )
            .formLogin()
            .successHandler(authenticationSuccessHandler())
            .and()
            .logout()
            .deleteCookies("JSESSIONID");
        return http.build();
    }

    @Bean
    AuthenticationSuccessHandler authenticationSuccessHandler() {
        return new CustomAuthenticationSuccessHandler();
    }
}

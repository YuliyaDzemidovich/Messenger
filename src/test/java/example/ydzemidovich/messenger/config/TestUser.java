package example.ydzemidovich.messenger.config;

import lombok.AllArgsConstructor;

import javax.security.auth.Subject;
import java.security.Principal;

/**
 * Test user to mock username
 */
@AllArgsConstructor
public class TestUser implements Principal {
    private String name;

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public boolean implies(Subject subject) {
        return Principal.super.implies(subject);
    }
}

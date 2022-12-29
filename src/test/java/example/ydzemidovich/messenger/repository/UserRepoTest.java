package example.ydzemidovich.messenger.repository;

import example.ydzemidovich.messenger.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Integration test for JPA repository and the real database
 */
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class UserRepoTest {

    @Autowired
    UserRepo userRepo;

    @Test
    void findUserByLogin() {
        User user = userRepo.findUserByLogin("johnD");
        assertNotNull(user);
        assertEquals("email@example.com", user.getEmail());
    }
}
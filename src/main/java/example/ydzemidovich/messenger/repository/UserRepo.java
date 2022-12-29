package example.ydzemidovich.messenger.repository;

import example.ydzemidovich.messenger.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * JPA Repository for the User entity.
 */
@Repository
public interface UserRepo extends JpaRepository<User, String> {

    /**
     * Get user by user login
     * @param login user login
     * @return user entity
     */
    User findUserByLogin(String login);
}

package example.ydzemidovich.messenger.repository;

import example.ydzemidovich.messenger.entity.Chat;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * JPA Repository for the Chat entity.
 */
public interface ChatRepo extends JpaRepository<Chat, String> {
}

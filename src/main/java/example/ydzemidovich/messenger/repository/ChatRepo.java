package example.ydzemidovich.messenger.repository;

import example.ydzemidovich.messenger.entity.Chat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * JPA Repository for the Chat entity.
 */
public interface ChatRepo extends JpaRepository<Chat, String> {

    /**
     * Get all chats for the provided username
     * @param userName username
     * @return list of chats found or an empty list
     */
    List<Chat> findByUsers_Login(String userName);
}

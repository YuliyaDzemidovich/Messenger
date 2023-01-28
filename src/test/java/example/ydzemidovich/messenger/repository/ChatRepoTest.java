package example.ydzemidovich.messenger.repository;

import example.ydzemidovich.messenger.entity.Chat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Integration test for JPA repository and the real database
 */
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class ChatRepoTest {

    @Autowired
    ChatRepo chatRepo;

    @Test
    void createChat() {
        Chat newChat = new Chat();
        newChat.setName("test chat");
        newChat.setCreatorId(1L);

        Chat savedChat = chatRepo.saveAndFlush(newChat);

        Chat fetchedChat = chatRepo.getReferenceById(savedChat.getId().toString());
        assertNotNull(fetchedChat);
        assertNotNull(fetchedChat.getId());
        assertEquals(newChat.getName(), fetchedChat.getName());
        assertEquals(newChat.getCreatorId(), fetchedChat.getCreatorId());
    }

    @Test
    void findByUsers_UserName() {
        List<Chat> userChats = chatRepo.findByUsers_Login("johnD");
        assertNotNull(userChats);
        assertTrue(userChats.size() > 0);
    }
}
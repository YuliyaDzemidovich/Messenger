package example.ydzemidovich.messenger.service.impl;

import example.ydzemidovich.messenger.config.TestUser;
import example.ydzemidovich.messenger.dto.ChatDto;
import example.ydzemidovich.messenger.dto.ChatUserDto;
import example.ydzemidovich.messenger.service.ChatService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.authentication.TestingAuthenticationToken;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ChatServiceImplTest {

    @Autowired
    private ChatService chatService;

    @Test
    @Transactional
    void getUserChats() {
        // mock authenticated user
        TestUser testUser = new TestUser("johnD");
        TestingAuthenticationToken authentication = new TestingAuthenticationToken(testUser, null);

        // method under test
        List<ChatDto> chats = chatService.getUserChats(authentication);

        // assertions
        assertNotNull(chats);
        assertTrue(chats.size() > 0);
        Optional<ChatDto> oneChatOpt = chats.stream()
                .filter(chat -> chat.getChatName().equals("John&Alice chat"))
                .findAny();
        assertTrue(oneChatOpt.isPresent());
        ChatDto oneChat = oneChatOpt.get();
        assertNotNull(oneChat);
        assertEquals("John&Alice chat", oneChat.getChatName());

        // assert John is present in the chat
        List<ChatUserDto> users = oneChat.getUsers();
        assertTrue(users.size() > 0);
        Optional<ChatUserDto> userOpt = users.stream()
                .filter(user -> user.getUserId().equals(1L))
                .findAny();
        assertTrue(userOpt.isPresent());
        ChatUserDto user = userOpt.get();
        assertEquals("john", user.getFirstName());
    }
}
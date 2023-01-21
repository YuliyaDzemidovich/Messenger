package example.ydzemidovich.messenger.service;

import example.ydzemidovich.messenger.dto.ChatDto;

import java.util.List;

/**
 * Service methods to work with Chats.
 */
public interface ChatService {

    /**
     * Get chats of current user.
     * @return list of user chats
     */
    List<ChatDto> getUserChats();
}

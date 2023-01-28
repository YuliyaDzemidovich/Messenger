package example.ydzemidovich.messenger.service;

import example.ydzemidovich.messenger.dto.ChatDto;

import java.security.Principal;
import java.util.List;

/**
 * Service methods to work with Chats.
 */
public interface ChatService {

    /**
     * Get chats of current user.
     * @param principal authenticated user
     * @return list of user chats
     */
    List<ChatDto> getUserChats(Principal principal);
}

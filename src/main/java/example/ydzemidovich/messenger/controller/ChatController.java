package example.ydzemidovich.messenger.controller;

import example.ydzemidovich.messenger.dto.ChatDto;
import example.ydzemidovich.messenger.service.ChatService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static example.ydzemidovich.messenger.Constants.API_VERSION;

/**
 * REST Controller with Chat endpoints.
 */
@RestController
@RequestMapping(API_VERSION + "/chats")
@RequiredArgsConstructor
public class ChatController {

    private final ChatService chatService;

    /**
     * Get all chats of current user.
     * @return list of chat for current user
     */
    @GetMapping(value = "/self", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ChatDto> getUserChats() {
        return chatService.getUserChats();
    }
}

package example.ydzemidovich.messenger.controller;

import example.ydzemidovich.messenger.dto.ChatMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

import java.security.Principal;

@Controller
public class SocketChatController {

    @MessageMapping("/chat.register")
    @SendTo("/topic/public")
    public ChatMessage register(@Payload ChatMessage chatMessage,
                                SimpMessageHeaderAccessor headerAccessor,
                                Principal principal) {
        String authUsername = principal.getName();
        headerAccessor.getSessionAttributes().put("username", authUsername);
        chatMessage.setSender(authUsername);
        return chatMessage;
    }

    @MessageMapping("/chat.send")
    @SendTo("/topic/public")
    public ChatMessage sendMessage(@Payload ChatMessage chatMessage) {
        return chatMessage;
    }
}
package example.ydzemidovich.messenger.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * DTO with info about Chat.
 */
@Getter
@Setter
public class ChatDto {
    private Long chatId;
    private String chatName;
    private String pictureUrl;
    private int usersCount;
    private List<ChatUserDto> users;
}

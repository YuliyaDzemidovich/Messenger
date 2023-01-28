package example.ydzemidovich.messenger.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * DTO with User info in the Chat.
 */
@Getter
@Setter
public class ChatUserDto {
    private Long userId;
    private String firstName;
    private String lastName;
}

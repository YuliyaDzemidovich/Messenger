package example.ydzemidovich.messenger.service.impl;

import example.ydzemidovich.messenger.dto.ChatDto;
import example.ydzemidovich.messenger.dto.ChatUserDto;
import example.ydzemidovich.messenger.service.ChatService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ChatServiceImpl implements ChatService {

    @Override
    public List<ChatDto> getUserChats() {
        //todo implement
        List<ChatDto> chats = new ArrayList<>();
        List<ChatUserDto> users = new ArrayList<>();
        ChatUserDto dto = new ChatUserDto();
        dto.setFirstName("mocked user chats list");
        users.add(dto);
        ChatDto chatDto = new ChatDto();
        chatDto.setUsers(users);
        chats.add(chatDto);
        return chats;
    }
}

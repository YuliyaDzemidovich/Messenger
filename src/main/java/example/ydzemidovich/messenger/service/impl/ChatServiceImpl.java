package example.ydzemidovich.messenger.service.impl;

import example.ydzemidovich.messenger.dto.ChatDto;
import example.ydzemidovich.messenger.dto.ChatUserDto;
import example.ydzemidovich.messenger.entity.Chat;
import example.ydzemidovich.messenger.entity.User;
import example.ydzemidovich.messenger.repository.ChatRepo;
import example.ydzemidovich.messenger.service.ChatService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class ChatServiceImpl implements ChatService {

    private final ChatRepo chatRepo;

    @Override
    public List<ChatDto> getUserChats(Principal principal) {
        List<Chat> chats = chatRepo.findByUsers_Login(principal.getName());
        List<ChatDto> chatDtos = new ArrayList<>();
        for (Chat chat : chats) {
            ChatDto chatDto = new ChatDto();
            chatDto.setChatId(chat.getId());
            chatDto.setChatName(chat.getName());
            chatDto.setPictureUrl(chat.getPictureUrl());
            chatDto.setUsersCount(chat.getUsers().size());
            List<ChatUserDto> userDtos = new ArrayList<>();
            for (User user : chat.getUsers()) {
                ChatUserDto userDto = new ChatUserDto();
                userDto.setUserId(user.getId());
                userDto.setFirstName(user.getFirstName());
                userDto.setLastName(user.getLastName());
                userDtos.add(userDto);
            }
            chatDto.setUsers(userDtos);
            chatDtos.add(chatDto);
        }
        return chatDtos;
    }
}

package com.example.demo.chat.service.facade;

import com.example.demo.chat.dto.ChatHistoryDto;
import com.example.demo.chat.entity.ChatHistory;
import com.example.demo.chat.service.ChatHistoryService;

import com.example.demo.custom.error.CustomErrorCode;
import com.example.demo.custom.error.CustomException;
import com.example.demo.user.service.UserService;
import com.example.demo.user.domain.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ChatHistoryFacade {

    private final UserService userService;
    private final ChatHistoryService chatHistoryService;


    public List<ChatHistoryDto> fetchChatHistory() {
        List<ChatHistory> chatHistoryList = chatHistoryService.todayChatMessageList();
        Map<Long, User> userMap = userService.getUser();

        List<ChatHistoryDto> todayChatList = chatHistoryList.stream().map(
                chatHistory -> new ChatHistoryDto(
                        userMap.get(chatHistory.getUserIdx()).getUserId(),
                        userMap.get(chatHistory.getUserIdx()).getUserName(),
                        chatHistory.getMessage(),
                        chatHistory.getSentDate()
                )
        ).collect(Collectors.toList());

        if (todayChatList.isEmpty()) {
            throw new CustomException(CustomErrorCode.CHATTING_LOG_NOT_FOUND);
        }

        return todayChatList;
    }


    public List<ChatHistoryDto> fetchAllChatHistory() {
        List<ChatHistory> allChatHistoryList = chatHistoryService.allChatList();
        Map<Long, User> userMap = userService.getUser();

        List<ChatHistoryDto> todayChatList = allChatHistoryList.stream().map(
                chatHistory -> new ChatHistoryDto(
                        userMap.get(chatHistory.getUserIdx()).getUserId(),
                        userMap.get(chatHistory.getUserIdx()).getUserName(),
                        chatHistory.getMessage(),
                        chatHistory.getSentDate()
                )
        ).collect(Collectors.toList());

        if (todayChatList.isEmpty()) {
            throw new CustomException(CustomErrorCode.CHATTING_LOG_NOT_FOUND);
        }

        return todayChatList;

    }

}


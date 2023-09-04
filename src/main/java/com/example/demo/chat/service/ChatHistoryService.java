package com.example.demo.chat.service;


import com.example.demo.chat.entity.ChatHistory;
import com.example.demo.chat.dto.ChatHistoryDto;
import com.example.demo.chat.repository.ChatHistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChatHistoryService {

    private final ChatHistoryRepository chatHistoryRepository;

    public void saveChatDetail(ChatHistoryDto chatHistoryDto) {
        ChatHistory chatHistory = ChatHistory.builder()
                .senderId(chatHistoryDto.getUserId())
                .senderName(chatHistoryDto.getUserName())
                .message(chatHistoryDto.getMessage())
                .build();

        chatHistoryRepository.save(chatHistory);

    }





}

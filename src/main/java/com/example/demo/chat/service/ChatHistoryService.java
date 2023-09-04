package com.example.demo.chat.service;


import com.example.demo.chat.entity.ChatHistory;
import com.example.demo.chat.dto.ChatHistoryDto;
import com.example.demo.chat.repository.ChatHistoryRepository;
import com.example.demo.custom.CustomErrorCode;
import com.example.demo.custom.dto.CustomException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

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

    public List<ChatHistory> chatHistoryList(ChatHistoryDto chatHistoryDto) {
        LocalDate endRange = chatHistoryDto.getTargetDate().plusMonths(1);
        List<ChatHistory> chatHistoryList = chatHistoryRepository.findAllBySendedDateBetween(LocalDate.now(), endRange);
        if (chatHistoryList.isEmpty()) {
            throw new CustomException(CustomErrorCode.CHATTING_LOG_NOT_FOUND);
        }

        return chatHistoryList;
    }







}

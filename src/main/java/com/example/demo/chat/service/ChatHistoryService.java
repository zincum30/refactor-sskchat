package com.example.demo.chat.service;



import com.example.demo.chat.entity.ChatHistory;
import com.example.demo.chat.repository.ChatHistoryRepository;
import com.example.demo.custom.error.CustomException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ChatHistoryService {

    private final ChatHistoryRepository chatHistoryRepository;

    public List<ChatHistory> todayChatMessageList() throws CustomException {

        LocalDateTime targetDate = LocalDate.now().atStartOfDay();
        LocalDateTime endDate = targetDate.plusDays(1);

        List<ChatHistory> repochatMessageList = chatHistoryRepository.findAllBySentDateBetween(targetDate, endDate);

        return repochatMessageList;
    }


    public List<ChatHistory> allChatList() throws CustomException {

        return chatHistoryRepository.findAll();

    }
}

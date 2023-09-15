package com.example.demo.chat.service;



import com.example.demo.chat.dto.ChatHistoryDto;
import com.example.demo.chat.entity.ChatHistory;
import com.example.demo.chat.repository.ChatHistoryRepository;
import com.example.demo.chat_view.dto.ChatViewDto;
import com.example.demo.custom.error.CustomErrorCode;
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


    public List<ChatHistory> todayChatMessageList() {

        LocalDateTime targetDate = LocalDate.now().atStartOfDay();
        LocalDateTime endDate = targetDate.plusDays(1);


        List<ChatHistory> repochatMessageList = chatHistoryRepository.findAllBySentDateBetween(targetDate, endDate);

        if (repochatMessageList.isEmpty()) {
            throw new CustomException(CustomErrorCode.CHATTING_LOG_NOT_FOUND);
        }

//        List<ChatHistoryDto> todayChatMessageList = repochatMessageList.stream()
//                .map(ChatHistory ->  new ChatHistoryDto(ChatHistory.getSenderId()))


        return repochatMessageList;
    }
}

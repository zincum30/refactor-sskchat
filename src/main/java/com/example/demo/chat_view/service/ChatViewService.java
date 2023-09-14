package com.example.demo.chat_view.service;

import com.example.demo.chat_view.dto.ChatViewDto;
import com.example.demo.chat_view.entity.ChatView;
import com.example.demo.chat_view.repository.ChatViewRepository;
import com.example.demo.custom.error.CustomErrorCode;
import com.example.demo.custom.error.CustomException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ChatViewService {

    private final ChatViewRepository chatViewRepository;

    public List<ChatView> todayChatList() {

        LocalDateTime targetDate = LocalDate.now().atStartOfDay();
        LocalDateTime endDate = targetDate.plusDays(1);

        List<ChatView> todayChatViewList = chatViewRepository.findAllBySentDateBetween(targetDate, endDate);
        if (todayChatViewList.isEmpty()) {
            throw new CustomException(CustomErrorCode.CHATTING_LOG_NOT_FOUND);
        }
        return todayChatViewList;
    }

}

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
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ChatViewService {

    private final ChatViewRepository chatViewRepository;

    public List<ChatViewDto> todayChatList() {

        LocalDateTime targetDate = LocalDate.now().atStartOfDay();
        LocalDateTime endDate = targetDate.plusDays(1);

        List<ChatView> repoChatViewList = chatViewRepository.findAllBySentDateBetween(targetDate, endDate);

        if (repoChatViewList.isEmpty()) {
            throw new CustomException(CustomErrorCode.CHATTING_LOG_NOT_FOUND);
        }

        List<ChatViewDto> todayChatViewList = repoChatViewList.stream()
                .map(ChatView -> new ChatViewDto(ChatView.getUserId(), ChatView.getUserName(),ChatView.getMessage(), ChatView.getSentDate()))
                .collect(Collectors.toList());

        return todayChatViewList;
    }

}




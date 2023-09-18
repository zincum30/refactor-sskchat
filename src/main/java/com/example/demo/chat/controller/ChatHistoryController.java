package com.example.demo.chat.controller;


import com.example.demo.chat.dto.ChatHistoryDto;
import com.example.demo.chat.service.ChatHistoryService;
import com.example.demo.chat.service.facade.ChatHistoryFacade;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/chat")
public class ChatHistoryController {

    private final ChatHistoryFacade chatHistoryFacade;

    @GetMapping
    public List<ChatHistoryDto> todayChatMessages() {
        return chatHistoryFacade.fetchChatHistory();

    }


    @GetMapping("/test")
    public List<ChatHistoryDto> allChatMessages() {
        return chatHistoryFacade.fetchAllChatHistory();
    }
}

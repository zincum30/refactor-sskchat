package com.example.demo.chat.controller;


import com.example.demo.chat.dto.ChatHistoryDto;
import com.example.demo.chat.entity.ChatHistory;
import com.example.demo.chat.service.ChatHistoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/chat")
public class ChatHistoryController {

    private final ChatHistoryService chatHistoryService;


    @GetMapping
    public List<ChatHistory> todayChatMessages() {
        return  chatHistoryService.todayChatMessageList();

    }

}

package com.example.demo.chat_view.controller;

import com.example.demo.chat_view.service.dto.ChatViewDto;
import com.example.demo.chat_view.service.ChatViewService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v2/chat")
public class ChatViewController {

    private final ChatViewService chatViewService;

    @GetMapping
    public List<ChatViewDto> todayChatList() {
        return chatViewService.todayChatList();
    }

    @GetMapping("/test")
    public List<ChatViewDto> allChatList() {
        return chatViewService.allChatList();
    }
}

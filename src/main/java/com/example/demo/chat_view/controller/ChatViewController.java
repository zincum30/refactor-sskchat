package com.example.demo.chat_view.controller;

import com.example.demo.chat_view.entity.ChatView;
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
    public List<ChatView> todayChatList() {
        return chatViewService.todayChatList();
    }
}

package com.example.demo.chat.controller;


import com.example.demo.chat.dto.ChatHistoryDto;
import com.example.demo.chat.entity.ChatHistory;
import com.example.demo.chat.service.ChatHistoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/chat")
public class ChatHistoryController {

    private final ChatHistoryService chatHistoryService;

    @PostMapping("/history")
    public ResponseEntity saveChatHistory(@RequestBody ChatHistoryDto chatHistoryDto) {
       chatHistoryService.saveChatDetail(chatHistoryDto);
       return ResponseEntity.ok().build();
    }



    @GetMapping("/history")
    public ResponseEntity chatHistoryList(@RequestBody ChatHistoryDto chatHistoryDto) {
        List<ChatHistory> chatHistoryList = chatHistoryService.chatHistoryList(chatHistoryDto);
        return ResponseEntity.ok(chatHistoryList);
    }

}

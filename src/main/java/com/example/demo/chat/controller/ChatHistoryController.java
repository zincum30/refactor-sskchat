package com.example.demo.chat.controller;


import com.example.demo.chat.dto.ChatHistoryDto;
import com.example.demo.chat.service.ChatHistoryService;
import com.example.demo.chat.service.facade.ChatHistoryFacade;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/chat")
@Tag(name = "채팅 컨트롤러")
public class ChatHistoryController {

    private final ChatHistoryFacade chatHistoryFacade;

    @Operation(summary = "채팅 내역 호출", description = "오늘 날짜의 전체 채팅 내역을 호출합니다.")
    @GetMapping
    public List<ChatHistoryDto> todayChatMessages() {
        return chatHistoryFacade.fetchChatHistory();

    }


    /*
    --- 채팅 목록 호출 속도 테스트 시

    @GetMapping("/test")
    public List<ChatHistoryDto> allChatMessages() {
        return chatHistoryFacade.fetchAllChatHistory();
    }
    */

}

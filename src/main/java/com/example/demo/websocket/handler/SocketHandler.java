package com.example.demo.websocket.handler;

import com.example.demo.user.entity.User;
import com.example.demo.chat.dto.ChatHistoryDto;
import com.example.demo.user.dto.ConnectedUserDto;
import com.example.demo.chat.service.ChatHistoryService;
import com.example.demo.user.service.UserService;
import com.example.demo.service.facade.ViewChatService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class SocketHandler extends TextWebSocketHandler {

    private final UserService userService;
    private final ChatHistoryService chatHistoryService;


    private final Map<WebSocketSession, User> userSessionList = new HashMap<>();


    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        URI sessionUri = session.getUri();
        if (sessionUri != null) {
            User currentUser = userService.getUserFromSession(sessionUri);
            ConnectedUserDto connectedUserDto = ConnectedUserDto.builder()
                    .userId(currentUser.get)
                    .build();
        }
    }


    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        String msg = message.getPayload();
        User sender = userSessionList.get(session);
        ChatHistoryDto chatHistoryDto = ChatHistoryDto.builder()
                .userId(sender.getUserId())
                .userName(sender.getUserName())
                .message(msg)
                .build();

        for(WebSocketSession sess : userSessionList.keySet().stream().toList()) {
            sess.sendMessage(new TextMessage(msg));
        }

    }


    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) {

        sessionList.remove(session);
    }


}

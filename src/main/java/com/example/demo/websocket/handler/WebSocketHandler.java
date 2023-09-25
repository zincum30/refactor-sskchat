package com.example.demo.websocket.handler;


import com.example.demo.user.domain.model.ConnectedUser;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Component
public class WebSocketHandler extends TextWebSocketHandler {


    private final List<WebSocketSession> sessionList = new ArrayList<>();
    private final Map<WebSocketSession, ConnectedUser> userSessionList = new HashMap<>();

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws IOException {
        String payload = message.getPayload();

        for(WebSocketSession sess: sessionList) {
            sess.sendMessage(message);
        }

    }


    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {

        sessionList.add(session);
    }


    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {
        sessionList.remove(session);
    }


}

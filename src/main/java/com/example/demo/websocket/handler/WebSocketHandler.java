package com.example.demo.websocket.handler;


import com.example.demo.user.domain.model.ConnectedUser;
import com.example.demo.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class WebSocketHandler extends TextWebSocketHandler {

    private final UserService userService;

    public static Map<WebSocketSession, ConnectedUser> userSessionList = new HashMap<>();

//    @Override
//    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
//        URI sessionUri = session.getUri();
//        UserEntity currentUserEntity = getUserFromSession(sessionUri);
//        userSessionList.put(session, currentUserEntity);
//    }



    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) {
        userSessionList.remove(session);
    }


}

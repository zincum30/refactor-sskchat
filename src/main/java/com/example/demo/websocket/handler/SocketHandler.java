package com.example.demo.websocket.handler;

import com.example.demo.user.entity.User;
import com.example.demo.chat.dto.ChatHistoryDto;
import com.example.demo.user.dto.ConnectedUserDto;
import com.example.demo.chat.service.ChatHistoryService;
import com.example.demo.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class SocketHandler extends TextWebSocketHandler {

    private final UserService userService;
    private final ChatHistoryService chatHistoryService;

    public static Map<WebSocketSession, User> userSessionList = new HashMap<>();


    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        URI sessionUri = session.getUri();
        User currentUser = getUserFromSession(sessionUri);
        userSessionList.put(session,currentUser);
    }


    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        String msg = message.getPayload();
        User sender = userSessionList.get(session);
        ChatHistoryDto chatHistoryDto = ChatHistoryDto.builder()
                .userId(sender.getUserId())
                .userName(sender.getUserName())
                .message(msg)
                .targetDate(LocalDateTime.now())
                .build();

        chatHistoryService.saveChatDetail(chatHistoryDto);

        for(WebSocketSession sess : userSessionList.keySet().stream().toList()) {
            sess.sendMessage(new TextMessage(msg));
        }

    }


    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) {
        userSessionList.remove(session);
    }


    public User getUserFromSession (URI userSessionUri) {

        String path = userSessionUri.getPath();
        String[] pathSegment = path.split("/");
        String userId = "";
        boolean isOnline = false;

        for (String segment : pathSegment) {
            if(isOnline) {
                userId = segment;
                break;
            }
            if (segment.equals("chat")) isOnline = true;
        }
        return userService.findUserById(userId);

    }


}

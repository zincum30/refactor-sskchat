package com.example.demo.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;

@Configuration
@RequiredArgsConstructor
@EnableWebSocket
public class WebSocketConfig {

<<<<<<< Updated upstream
    
=======

    public final SocketHandler socketHandler;

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(socketHandler, "/chat/{userId}")
                .setAllowedOriginPatterns("*");
    }

>>>>>>> Stashed changes
}

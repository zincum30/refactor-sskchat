package com.example.demo.custom.response;

import lombok.Builder;
import lombok.Getter;
import org.springframework.http.ResponseEntity;

@Getter
@Builder
public class ResponseMessageBuilder {

    private final String message;

    public static ResponseEntity<ResponseMessageBuilder> toResponseEntity(ResponseMessageCode responseMessageCode) {
        return ResponseEntity
                .ok()
                .body(ResponseMessageBuilder.builder()
                        .message(responseMessageCode.getMessage())
                        .build()
                );

    }
}

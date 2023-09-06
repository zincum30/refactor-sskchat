package com.example.demo.custom.service;

import lombok.Builder;
import lombok.Getter;
import org.springframework.http.ResponseEntity;

@Getter
@Builder
public class CustomExceptionResponse {

    private final String error;
    private final String message;

    public static ResponseEntity<CustomExceptionResponse> toResponseEntity(CustomErrorCode customErrorCode) {
        return ResponseEntity
                .status(customErrorCode.getHttpStatus())
                .body(CustomExceptionResponse.builder()
                        .error(customErrorCode.getHttpStatus().name())
                        .message(customErrorCode.getDetail())
                        .build()
                );


    }
}

package com.example.demo.custom.error;

import lombok.Builder;
import lombok.Getter;
import org.springframework.http.ResponseEntity;

@Getter
@Builder
public class CustomExceptionResponseBuilder {

    private final String error;
    private final String message;

    public static ResponseEntity<CustomExceptionResponseBuilder> toResponseEntity(CustomErrorCode customErrorCode) {
        return ResponseEntity
                .status(customErrorCode.getHttpStatus())
                .body(CustomExceptionResponseBuilder.builder()
                        .error(customErrorCode.getHttpStatus().name())
                        .message(customErrorCode.getDetail())
                        .build()
                );


    }
}

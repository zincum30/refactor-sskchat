package com.example.demo.domain.dto;

import com.example.demo.domain.CustomErrorCode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
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

package com.example.demo.custom.error;

import com.example.demo.custom.error.CustomErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CustomException extends RuntimeException {

    private final CustomErrorCode customErrorCode;

}


package com.example.demo.custom.dto;

import com.example.demo.custom.service.CustomErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CustomException extends RuntimeException {

    private final CustomErrorCode customErrorCode;

}


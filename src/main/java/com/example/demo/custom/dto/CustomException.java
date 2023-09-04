package com.example.demo.custom.dto;


import com.example.demo.custom.CustomErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CustomException extends RuntimeException{

    private final CustomErrorCode customErrorCode;

}

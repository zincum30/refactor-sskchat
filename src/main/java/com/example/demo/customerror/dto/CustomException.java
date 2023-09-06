package com.example.demo.customerror.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CustomException extends RuntimeException{

    private final CustomErrorCode customErrorCode;

}

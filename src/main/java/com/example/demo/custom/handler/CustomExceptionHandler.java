package com.example.demo.custom.handler;


import com.example.demo.custom.dto.CustomException;
import com.example.demo.custom.service.CustomExceptionResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<CustomExceptionResponse> handleCustomException (CustomException customException) {
        return CustomExceptionResponse.toResponseEntity(customException.getCustomErrorCode());
    }

}

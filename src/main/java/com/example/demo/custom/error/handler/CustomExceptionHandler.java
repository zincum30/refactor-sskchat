package com.example.demo.custom.error.handler;


import com.example.demo.custom.error.CustomException;
import com.example.demo.custom.error.CustomExceptionResponseBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<CustomExceptionResponseBuilder> handleCustomException (CustomException customException) {
        return CustomExceptionResponseBuilder.toResponseEntity(customException.getCustomErrorCode());
    }

}


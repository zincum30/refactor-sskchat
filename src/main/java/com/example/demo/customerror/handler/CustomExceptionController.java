package com.example.demo.customerror.handler;


import com.example.demo.customerror.dto.CustomException;
import com.example.demo.customerror.service.CustomExceptionResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class CustomExceptionController extends ResponseEntityExceptionHandler {

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<CustomExceptionResponse> handleCustomException (CustomException customException) {
        return CustomExceptionResponse.toResponseEntity(customException.getCustomErrorCode());
    }

}

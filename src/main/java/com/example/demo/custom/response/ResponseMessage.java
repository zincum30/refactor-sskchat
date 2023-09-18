package com.example.demo.custom.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@AllArgsConstructor
public class ResponseMessage {

    private final ResponseMessageCode responseMessageCode;

}

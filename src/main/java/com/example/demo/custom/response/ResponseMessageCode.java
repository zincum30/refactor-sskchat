package com.example.demo.custom.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@AllArgsConstructor
public enum ResponseMessageCode {


    CREATED_USER("회원가입 성공"),
    AVAILABLE_ID("사용가능한 아이디 입니다."),
    LOGIN_SUCCESS( "로그인 성공");

    private final String message;

}

package com.example.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.CONFLICT;
import static org.springframework.http.HttpStatus.NOT_FOUND;


@Getter
@AllArgsConstructor
public enum CustomErrorCode {

    // 400 BAD_REQUEST
    NOT_NULL(BAD_REQUEST,"Id must be not null"),


    // 404 NOT_FOUND
    USER_NOT_FOUND(NOT_FOUND,"존재하지 않는 사용자입니다."),
    CHATTING_LOG_NOT_FOUND(NOT_FOUND, "요청하신 날짜에 채팅 내역이 없습니다."),


    // 409 CONFLICT
    CONFLICT_ID(CONFLICT, "이미 사용 중인 아이디입니다.");


    private final HttpStatus httpStatus;
    private final String detail;

}

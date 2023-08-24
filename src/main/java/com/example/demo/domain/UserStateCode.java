package com.example.demo.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum UserStateCode {
    ON_LINE, OFF_LINE;
}

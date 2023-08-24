package com.example.demo.controller;


import com.example.demo.domain.dto.FindUserPasswordDto;
import com.example.demo.domain.dto.FindUserIdDto;
import com.example.demo.domain.dto.LoginDto;
import com.example.demo.domain.dto.RegisterDto;
import com.example.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RequiredArgsConstructor
@RestControllerAdvice
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    @PutMapping("/register")
    public Object createAccount(@RequestBody RegisterDto registerDto) {
        userService.createAccount(registerDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/check-duplicated-id")
    public Object checkDuplicatedId(String userId) {
        Assert.notNull(userId, "Id must not be null");
        if (userService.checkDuplicatedId(userId)) {
            return ResponseEntity.ok("available");
        }
        else {
            return "CONFLICT_ID";
        }

    }


    @GetMapping("/find-id")
    public String findUserId(FindUserIdDto findUserIdDto) {
        return userService.findUserId(findUserIdDto);
    }


    @GetMapping("/find-password")
    public String findUserPassword(FindUserPasswordDto findUserPasswordDto) {
        return userService.findUserPassword(findUserPasswordDto);
    }


//    @GetMapping("/login")
//    public Object login() {
//    }




}

package com.example.demo.controller;


import com.example.demo.domain.CustomErrorCode;
import com.example.demo.domain.dto.FindUserIdDto;
import com.example.demo.domain.dto.FindUserPasswordDto;
import com.example.demo.domain.dto.RegisterDto;
import com.example.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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
    public Object checkDuplicatedId(@RequestParam(name = "userId") String userId) {
        userService.checkDuplicatedId(userId);
        return ResponseEntity.ok("available");
    }

    @PostMapping("/find-id")
    public String findUserId(@RequestBody FindUserIdDto findUserIdDto){
        return userService.findUserId(findUserIdDto);
    }


    @PostMapping("/find-password")
    public String findUserPassword(FindUserPasswordDto findUserPasswordDto) {
        return userService.findUserPassword(findUserPasswordDto);
    }

    
}

package com.example.demo.user.controller;


import com.example.demo.custom.response.ResponseMessage;
import com.example.demo.custom.response.ResponseMessageCode;
import com.example.demo.user.domain.dto.FindUserIdDto;
import com.example.demo.user.domain.dto.FindUserPasswordDto;
import com.example.demo.user.domain.dto.LoginDto;
import com.example.demo.user.domain.dto.RegisterDto;
import com.example.demo.user.service.UserService;
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
import org.springframework.web.bind.annotation.RestController;



@RequiredArgsConstructor
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    @PutMapping("/register")
    public ResponseMessage createAccount(@RequestBody RegisterDto registerDto) {
        userService.createAccount(registerDto);
        return new ResponseMessage(ResponseMessageCode.CREATED_USER);
    }

    @GetMapping("/check-duplicated-id")
    public ResponseEntity checkDuplicatedId(@RequestParam(name = "userId") String userId) {
        userService.checkDuplicatedId(userId);
        return ResponseEntity.ok().body(ResponseMessageCode.AVAILABLE_ID.getMessage());
    }

    @PostMapping("/find-id")
    public String findUserId(@RequestBody FindUserIdDto findUserIdDto){
        return userService.findUserId(findUserIdDto);
    }


    @PostMapping("/find-password")
    public String findUserPassword(@RequestBody FindUserPasswordDto findUserPasswordDto) {
        return userService.findUserPassword(findUserPasswordDto);
    }

    @PostMapping("/login")
    public HttpStatus login(@RequestBody LoginDto loginDto) {
        userService.login(loginDto);
        return HttpStatus.valueOf("Success");
    }


}

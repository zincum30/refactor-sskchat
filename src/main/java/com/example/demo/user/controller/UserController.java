package com.example.demo.user.controller;


import com.example.demo.custom.response.ResponseMessage;
import com.example.demo.custom.response.ResponseMessageCode;
import com.example.demo.user.domain.dto.FindUserIdDto;
import com.example.demo.user.domain.dto.FindUserPasswordDto;
import com.example.demo.user.domain.dto.LoginDto;
import com.example.demo.user.domain.dto.RegisterDto;
import com.example.demo.user.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name = "유저 컨트롤러")
public class UserController {

    private final UserService userService;

    @Operation(summary = "회원가입")
    @PutMapping("/register")
    public ResponseEntity<String> createAccount(@RequestBody RegisterDto registerDto) {
        userService.createAccount(registerDto);
        return ResponseEntity.ok().body(ResponseMessageCode.CREATED_USER.getMessage());
    }

    @Operation(summary = "아이디 중복 여부 확인")
    @GetMapping("/check-duplicated-id")
    public ResponseEntity<String> checkDuplicatedId(@RequestParam(name = "userId") String userId) {
        userService.checkDuplicatedId(userId);
        return ResponseEntity.ok().body(ResponseMessageCode.AVAILABLE_ID.getMessage());
    }

    @Operation(summary = "아이디 찾기")
    @GetMapping("/find-id")
    public String findUserId(@RequestBody FindUserIdDto findUserIdDto){
        return userService.findUserId(findUserIdDto);
    }


    @Operation(summary = "비밀번호 찾기")
    @GetMapping("/find-password")
    public String findUserPassword(@RequestBody FindUserPasswordDto findUserPasswordDto) {
        return userService.findUserPassword(findUserPasswordDto);
    }

    @Operation(summary = "로그인")
    @GetMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginDto loginDto) {
        userService.login(loginDto);
        return ResponseEntity.ok().body(ResponseMessageCode.LOGIN_SUCCESS.getMessage());




    }


}

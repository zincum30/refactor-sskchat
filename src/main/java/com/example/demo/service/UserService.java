package com.example.demo.service;

import com.example.demo.domain.User;
import com.example.demo.domain.dto.FindUserPasswordDto;
import com.example.demo.domain.dto.FindUserIdDto;
import com.example.demo.domain.dto.LoginDto;
import com.example.demo.domain.dto.RegisterDto;
import com.example.demo.repository.UserRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional(rollbackFor = Exception.class)
    public void createAccount(RegisterDto registerDto) {

        User user = User.builder()
                .userId(registerDto.getUserId())
                .userPassword(registerDto.getUserPassword())
                .userName(registerDto.getUserName())
                .userEmail(registerDto.getUserEmail())
                .build();

        userRepository.save(user);
    }

    public boolean checkDuplicatedId(String userId) {
        return !userRepository.existsByUserId(userId);
    }


    public String findUserId(FindUserIdDto findUserIdDto) {
        String insertedName = findUserIdDto.getUserName();
        String insertedEmail = findUserIdDto.getUserEmail();
        return userRepository
                .findByUserNameAndUserEmail(insertedName, insertedEmail);
    }


    public String findUserPassword(FindUserPasswordDto findUserPasswordDto) {
        String insertedId = findUserPasswordDto.getUserId();
        String insertedName = findUserPasswordDto.getUserName();
        String insertedEmail = findUserPasswordDto.getUserEmail();
        return userRepository
                .findUserPasswordByUserIdAndUserNameAndUserEmail(insertedId, insertedName,insertedEmail);
    }

    public boolean Login (LoginDto loginDto) {
        return userRepository
                .existsByUserIdAndUserPassword(loginDto.getUserId(), loginDto.getUserPassword());
    }


}

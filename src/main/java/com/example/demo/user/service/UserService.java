package com.example.demo.user.service;


import com.example.demo.custom.dto.CustomException;
import com.example.demo.custom.service.CustomErrorCode;
import com.example.demo.user.dto.ConnectedUserDto;
import com.example.demo.user.dto.FindUserIdDto;
import com.example.demo.user.dto.FindUserPasswordDto;
import com.example.demo.user.dto.LoginDto;
import com.example.demo.user.dto.RegisterDto;
import com.example.demo.user.entity.User;
import com.example.demo.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


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


    public void checkDuplicatedId(String userId) {
        if (userRepository.findByUserId(userId) != null) {
            throw new CustomException(CustomErrorCode.CONFLICT_ID);
        }
    }

    public String findUserId(FindUserIdDto findUserIdDto) {
        String userName = findUserIdDto.getUserName();
        String userEmail = findUserIdDto.getUserEmail();
        Optional<User> user = userRepository.findByUserNameAndUserEmail(userName, userEmail);

        if (user.isPresent()) {
            return user.get().getUserId();
        } else throw new CustomException(CustomErrorCode.USER_NOT_FOUND);
    }


    public String findUserPassword(FindUserPasswordDto findUserPasswordDto) {
        String userId = findUserPasswordDto.getUserId();
        String userName = findUserPasswordDto.getUserName();
        String userEmail = findUserPasswordDto.getUserEmail();
        Optional<User> user = userRepository.findByUserIdAndUserNameAndUserEmail(userId, userName, userEmail);

        if (user.isPresent()) {
            return user.get().getUserPassword();
        } else throw new CustomException(CustomErrorCode.USER_NOT_FOUND);
    }

    public void login(LoginDto loginDto) {
        String userId = loginDto.getUserId();
        String userPassword = loginDto.getUserPassword();
        Optional<User> user = userRepository.findByUserIdAndUserPassword(userId, userPassword);

        if (user.isEmpty()) {
            throw new CustomException(CustomErrorCode.USER_NOT_FOUND);
        }
    }

    public void logindUser(ConnectedUserDto connectedUserDto) {

        if (connectedUserDto != null) {
            User userId = userRepository.findByUserId(connectedUserDto.getUserId());
            User userName = userRepository.findByUserName(connectedUserDto.getUserName());
        } else throw new CustomException(NOT_NULL);
    }


    public List<User> getUserList() {
        return userRepository.findAll();
    }


    public User findUserById(String userId) {
        return userRepository.findByUserId(userId);

    }


}

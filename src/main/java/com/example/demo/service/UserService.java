package com.example.demo.service;

import com.example.demo.controller.CustomExceptionController;
import com.example.demo.domain.CustomException;
import com.example.demo.domain.User;
import com.example.demo.domain.dto.FindUserPasswordDto;
import com.example.demo.domain.dto.FindUserIdDto;
import com.example.demo.domain.dto.LoginDto;
import com.example.demo.domain.dto.RegisterDto;
import com.example.demo.repository.UserRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static com.example.demo.domain.CustomErrorCode.CONFLICT_ID;
import static com.example.demo.domain.CustomErrorCode.USER_NOT_FOUND;

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
        if (userRepository.findById(userId).isPresent()) {
            throw new CustomException(CONFLICT_ID);
        }
    }

    public String findUserId(FindUserIdDto findUserIdDto) {
        String userName = findUserIdDto.getUserName();
        String userEmail = findUserIdDto.getUserEmail();
        Optional<User> user = userRepository.findByUserNameAndUserEmail(userName, userEmail);

        if (user.isPresent()) {
            return user.get().getUserId();
        }
        else throw new CustomException(USER_NOT_FOUND);
    }


    public String findUserPassword(FindUserPasswordDto findUserPasswordDto) {
        String userId = findUserPasswordDto.getUserId();
        String userName = findUserPasswordDto.getUserName();
        String userEmail = findUserPasswordDto.getUserEmail();
        Optional<User> user = userRepository.findByUserIdAndUserNameAndUserEmail(userId, userName,userEmail);

        if (user.isPresent()) {
            return user.get().getUserPassword();
        }
        else throw new CustomException(USER_NOT_FOUND);
    }


}

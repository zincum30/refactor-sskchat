package com.example.demo.service;

import com.example.demo.domain.User;
import com.example.demo.domain.dto.RegisterDto;
import com.example.demo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public void createAccount(RegisterDto registerDto) {

        User user = User.builder()
                .userId(registerDto.getUserId())
                .userPassword(registerDto.getUserPassword())
                .userName(registerDto.getUserName())
                .userEmail(registerDto.getUserEmail())
                .build();

        userRepository.save(user);
    }

    public boolean checkDuplicatedId(String userId) throws IllegalArgumentException {
        return !userRepository.existsById(userId);
    }


}

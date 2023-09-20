package com.example.demo.user.service;


import com.example.demo.custom.error.CustomErrorCode;
import com.example.demo.custom.error.CustomException;
import com.example.demo.user.domain.dto.FindUserIdDto;
import com.example.demo.user.domain.dto.FindUserPasswordDto;
import com.example.demo.user.domain.dto.LoginDto;
import com.example.demo.user.domain.dto.RegisterDto;
import com.example.demo.user.repository.UserRepository;
import com.example.demo.user.domain.entity.UserEntity;
import com.example.demo.user.domain.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional(rollbackFor = Exception.class)
    public void createAccount(RegisterDto registerDto) {

        UserEntity userEntity = UserEntity.builder()
                .userId(registerDto.getUserId())
                .userPassword(registerDto.getUserPassword())
                .userName(registerDto.getUserName())
                .userEmail(registerDto.getUserEmail())
                .build();

        userRepository.save(userEntity);
    }


    public void checkDuplicatedId(String userId) {
        if (userRepository.findByUserId(userId) != null) {
            throw new CustomException(CustomErrorCode.CONFLICT_ID);
        }
    }

    public String findUserId(FindUserIdDto findUserIdDto) {
        String userName = findUserIdDto.getUserName();
        String userEmail = findUserIdDto.getUserEmail();
        Optional<UserEntity> user = userRepository.findByUserNameAndUserEmail(userName, userEmail);

        if (user.isPresent()) {
            return user.get().getUserId();
        } else throw new CustomException(CustomErrorCode.USER_NOT_FOUND);
    }


    public String findUserPassword(FindUserPasswordDto findUserPasswordDto) {
        String userId = findUserPasswordDto.getUserId();
        String userName = findUserPasswordDto.getUserName();
        String userEmail = findUserPasswordDto.getUserEmail();
        Optional<UserEntity> user = userRepository.findByUserIdAndUserNameAndUserEmail(userId, userName, userEmail);

        if (user.isPresent()) {
            return user.get().getUserPassword();
        } else throw new CustomException(CustomErrorCode.USER_NOT_FOUND);
    }

    public void login(LoginDto loginDto) {
        String userId = loginDto.getUserId();
        String userPassword = loginDto.getUserPassword();
        Optional<UserEntity> user = userRepository.findByUserIdAndUserPassword(userId, userPassword);

        if (user.isEmpty()) {
            throw new CustomException(CustomErrorCode.USER_NOT_FOUND);
        }
    }

    public void loginedUser(ConnectedUserDto connectedUserDto) {

        if (connectedUserDto != null) {
            UserEntity userEntityId = userRepository.findByUserId(connectedUserDto.getUserId());
            UserEntity userEntityName = userRepository.findByUserName(connectedUserDto.getUserName());
        } else throw new CustomException(CustomErrorCode.NOT_NULL);
    }


    public List<UserEntity> getUserList() {
        return userRepository.findAll();
    }

//
//    public Map<Long, UserEntity> getUserMap() {
//        return userRepository.findAll().stream().collect(Collectors.toMap(
//                userEntity -> userEntity.getIdx(),
//                userEntity -> userEntity
//
//        ));
//    }

    public Map<Long, User> getUser() {

        Map<Long, User> userMap = userRepository.findAll().stream()
                .collect(Collectors.toMap(
                                getUser -> getUser.getIdx(),
                                getUser -> User.builder()
                                        .userId(getUser.getUserId())
                                        .userName(getUser.getUserName())
                                        .build()
                        )
                );

        return userMap;
    }

    public UserEntity findUserById(String userId) {
        return userRepository.findByUserId(userId);

    }


}

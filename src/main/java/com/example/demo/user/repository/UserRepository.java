package com.example.demo.user.repository;

import com.example.demo.user.domain.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {


    UserEntity findByUserId(String userId);

    UserEntity findByUserName(String userName);

    UserEntity findByIdx(Long idx);

    Optional<UserEntity> findByUserIdAndUserPassword(String userId, String userPassword);

    Optional<UserEntity> findByUserNameAndUserEmail(String userName, String userEmail);

    Optional<UserEntity> findByUserIdAndUserNameAndUserEmail(String userId, String userName, String userEmail);


}

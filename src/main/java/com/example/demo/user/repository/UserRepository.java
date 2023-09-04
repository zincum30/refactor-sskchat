package com.example.demo.user.repository;

import com.example.demo.user.entity.User;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUserId(@NotNull String userId);

    User findByUserName(@NotNull String userName);

    Optional<User> findByUserNameAndUserEmail(String userName, String userEmail);

    Optional<User> findByUserIdAndUserNameAndUserEmail(String userId, String userName, String userEmail);

    Optional<User> findByUserIdAndUserPassword(String userId, String userPassword);


}

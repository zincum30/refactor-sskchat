package com.example.demo.repository;

import com.example.demo.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<User, String> {

    Optional<User> findByUserNameAndUserEmail(String userName, String userEmail);

    Optional<User> findByUserIdAndUserNameAndUserEmail(String userId, String userName, String userEmail);

}

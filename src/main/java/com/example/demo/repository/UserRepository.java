package com.example.demo.repository;

import com.example.demo.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User, String> {

    public String findByUserNameAndUserEmail(String userName, String userEmail);

    public String findUserPasswordByUserIdAndUserNameAndUserEmail(String userId, String userName, String userEmail);

    public boolean existsByUserIdAndUserPassword(String userId, String Password);

    public boolean existsByUserId(String userId);
}

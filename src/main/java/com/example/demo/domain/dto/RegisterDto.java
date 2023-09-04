package com.example.demo.domain.dto;

import jakarta.persistence.EntityListeners;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
<<<<<<< Updated upstream:src/main/java/com/example/demo/domain/dto/RegisterDto.java
=======
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;
>>>>>>> Stashed changes:src/main/java/com/example/demo/chat/dto/ChatHistoryDto.java

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class RegisterDto {

    String userId;
    String userPassword;
    String userName;
<<<<<<< Updated upstream:src/main/java/com/example/demo/domain/dto/RegisterDto.java
    String userEmail;


=======
    String message;
    LocalDate targetDate;
>>>>>>> Stashed changes:src/main/java/com/example/demo/chat/dto/ChatHistoryDto.java

}

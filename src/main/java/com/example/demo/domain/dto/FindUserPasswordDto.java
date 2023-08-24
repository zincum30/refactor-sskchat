package com.example.demo.domain.dto;

import jakarta.persistence.EntityListeners;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class FindUserPasswordDto {

    String userId;
    String userName;
    String userEmail;

}

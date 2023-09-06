package com.example.demo.domain.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Immutable;

import java.time.LocalDate;

@Getter
@Entity
@Builder
@Table(name = "view_chat")
@AllArgsConstructor
@NoArgsConstructor
public class ViewChat {

    @Id
    Long chatHistoryIndex;
    String userId;
    String userName;
    String message;
    @CreationTimestamp
    LocalDate sendedDate;



}

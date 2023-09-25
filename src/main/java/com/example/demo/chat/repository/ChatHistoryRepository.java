package com.example.demo.chat.repository;

import com.example.demo.chat.entity.ChatHistoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ChatHistoryRepository extends JpaRepository<ChatHistoryEntity, Long> {


    List<ChatHistoryEntity> findAllBySentDateBetween(LocalDateTime targetDate, LocalDateTime endDate);



}

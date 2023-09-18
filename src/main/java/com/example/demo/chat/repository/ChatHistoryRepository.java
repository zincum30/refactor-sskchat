package com.example.demo.chat.repository;

import com.example.demo.chat.entity.ChatHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ChatHistoryRepository extends JpaRepository<ChatHistory, Long> {


    List<ChatHistory> findAllBySentDateBetween(LocalDateTime targetDate, LocalDateTime endDate);



}

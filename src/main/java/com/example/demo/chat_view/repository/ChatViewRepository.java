package com.example.demo.chat_view.repository;

import com.example.demo.chat_view.entity.ChatView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ChatViewRepository extends JpaRepository<ChatView, Long> {

    List<ChatView> findAllBySentDateBetween(LocalDateTime targetDate, LocalDateTime endDate);

}

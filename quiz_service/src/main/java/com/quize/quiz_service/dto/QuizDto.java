package com.quize.quiz_service.dto;

import com.quize.quiz_service.entity.Quiz;

import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizDto extends JpaRepository<Quiz,Integer> {
}

package com.quiz.entity;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result {
    private Long id;
    private Long quizId;
    private Long userId;
    private int score;
    private LocalDateTime submittedAt;
}

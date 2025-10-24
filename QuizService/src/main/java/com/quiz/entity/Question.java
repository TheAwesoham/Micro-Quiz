package com.quiz.entity;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Question {
    
    private Long questionId;
    private String question;
    private Long quizId;
    private String correctAnswer;
    private List<String> options;
}

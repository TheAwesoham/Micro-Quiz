package com.quiz.service;

import java.util.List;

import com.quiz.dto.SubmissionDto;
import com.quiz.entity.Question;
import com.quiz.entity.Quiz;

public interface QuizService {
    
    Quiz add(Quiz quiz);

    List<Quiz> get();

    Quiz get(Long id);

    List<Question> startQuiz(Long quizId);

    int submitQuiz(SubmissionDto submission);
}

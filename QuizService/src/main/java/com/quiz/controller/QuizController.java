package com.quiz.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.dto.SubmissionDto;
import com.quiz.entity.Question;
import com.quiz.entity.Quiz;
import com.quiz.service.QuizService;

@RestController
@RequestMapping("/quiz")
public class QuizController {
    
    private QuizService quizService;

    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }

    @PostMapping
    public Quiz create(@RequestBody Quiz quiz){
        return quizService.add(quiz);
    }

    @GetMapping
    public List<Quiz> getAll(){
        return quizService.get();
    }

    @GetMapping("/{id}")
    public Quiz getOne(@PathVariable Long id){
        return quizService.get(id);
    }

    @GetMapping("/start/{quizId}")
    public List<Question> startQuiz(@PathVariable Long quizId) {
        return quizService.startQuiz(quizId);
    }

    @PostMapping("/submit")
    public ResponseEntity<String> submitQuiz(@RequestBody SubmissionDto submission) {
        int score = quizService.submitQuiz(submission);
        return ResponseEntity.ok("Your score is: " + score);
    }
}

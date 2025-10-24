package com.question.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.question.entity.Question;
import com.question.service.QuestionService;
import com.question.service.impl.QuestionServiceImpl;

@RestController
@RequestMapping("/question")
public class QuestionController {
    
    private QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @PostMapping
    public Question create(@RequestBody Question question){
        return questionService.create(question);
    }

    @GetMapping
    public List<Question> getAll(){
        return questionService.get();
    }

    @GetMapping("/{questionId}")
    public Question getOne(@PathVariable Long questionId){
        return questionService.getOne(questionId);
    }

    //get questions for the quiz without the correct answers (for users)
    @GetMapping("/quiz/{quizId}")
    public List<Question> getOnlyQuestionsFromQuiz(@PathVariable Long quizId) {
        if (questionService instanceof QuestionServiceImpl) {
            return ((QuestionServiceImpl) questionService).getQuestionsFromQuiz(quizId);
        }
        return questionService.getOnlyQuestionsFromQuiz(quizId);
    }

    //get questions with correct answers (for QuizService evaluation)
    @GetMapping("/answers/{quizId}")
    public List<Question> getCorrectAnswers(@PathVariable Long quizId) {
        return questionService.getQuestionsFromQuiz(quizId);
    }
}

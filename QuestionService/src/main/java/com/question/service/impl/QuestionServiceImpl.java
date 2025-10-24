package com.question.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.question.entity.Question;
import com.question.repository.QuestionRepository;
import com.question.service.QuestionService;

@Service
public class QuestionServiceImpl implements QuestionService{
    
    private QuestionRepository questionRepository;

    public QuestionServiceImpl(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @Override
    public Question create(Question question) {
        return questionRepository.save(question);
    }

    @Override
    public List<Question> get() {
        return questionRepository.findAll();
    }

    @Override
    public Question getOne(Long id) {
        return questionRepository.findById(id).orElseThrow(() -> new RuntimeException("question not found"));
    }

    @Override
    public List<Question> getQuestionsFromQuiz(Long quizId){
        return questionRepository.findByQuizId(quizId);
    }

    //returns the questions without correct answers for the QuizService
    @Override
    public List<Question> getOnlyQuestionsFromQuiz(Long quizId) {
        return getQuestionsFromQuiz(quizId).stream()
                .map(q -> new Question(q.getQuestionId(), q.getQuestion(), q.getQuizId(), null, q.getOptions()))
                .collect(Collectors.toList());
    }
}

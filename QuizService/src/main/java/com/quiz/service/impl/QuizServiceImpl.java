package com.quiz.service.impl;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.quiz.dto.AnswerDto;
import com.quiz.dto.SubmissionDto;
import com.quiz.entity.Question;
import com.quiz.entity.Quiz;
import com.quiz.entity.Result;
import com.quiz.repository.QuizRepository;
import com.quiz.service.QuestionClient;
import com.quiz.service.QuizService;
import com.quiz.service.ResultClient;

@Service
public class QuizServiceImpl implements QuizService{

    private QuizRepository quizRepository;

    private QuestionClient questionClient;

    private ResultClient resultClient;

    public QuizServiceImpl(QuizRepository quizRepository, QuestionClient questionClient, ResultClient resultClient) {
        this.quizRepository = quizRepository;
        this.questionClient = questionClient;
        this.resultClient = resultClient;
    }

    @Override
    public Quiz add(Quiz quiz) {
        return quizRepository.save(quiz);
    }

    @Override
    public List<Quiz> get() {
        List<Quiz> quizzes = quizRepository.findAll();

        List<Quiz> newQuizList = quizzes.stream().map(quiz -> {
            quiz.setQuestions(questionClient.getOnlyQuestionsFromQuiz(quiz.getId()));
            return quiz;
        }).collect(Collectors.toList());
        return newQuizList;
    }

    @Override
    public Quiz get(Long id) {
        Quiz quiz = quizRepository.findById(id).orElseThrow(() -> new RuntimeException("quiz not found"));
        quiz.setQuestions(questionClient.getOnlyQuestionsFromQuiz(quiz.getId()));
        return quiz;
    }

    @Override
    public List<Question> startQuiz(Long quizId) {
        return questionClient.getCorrectAnswers(quizId);
    }

    @Override
    public int submitQuiz(SubmissionDto submission) {
        List<Question> correctQuestions = questionClient.getCorrectAnswers(submission.getQuizId());

        Map<Long, String> correctMap = correctQuestions.stream()
                .collect(Collectors.toMap(Question::getQuestionId, Question::getCorrectAnswer));

        int score = 0;
        for (AnswerDto ans : submission.getAnswers()) {
            String correct = correctMap.get(ans.getQuestionId());
            if (correct != null && correct.equalsIgnoreCase(ans.getGivenAnswer())) {
                score++;
            }
        }
        Result result = new Result();
        result.setQuizId(submission.getQuizId());
        result.setUserId(submission.getUserId());
        result.setScore(score);
        resultClient.saveResult(result);

        return score;
    }
}

package com.quiz.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.quiz.entity.Question;

//the Eureka Server starts and the Service Registry contains information about all running services  
//the Eureka Client is responsible for registering your microservice with the Eureka Server and discovering other services from it when needed
//Feign calls the LoadBalancer to fetch all available instances of "QUESTION-SERVICE"
//the LoadBalancer asks Eureka Client for registered instances
//the LoadBalancer picks one instance using its selection algorithm 
//Feign then sends the actual HTTP request to the chosen instance
//the response then comes back from "QUESTION-SERVICE"
@FeignClient(name = "QUESTION-SERVICE")
public interface QuestionClient {
    
    @GetMapping("/question/quiz/{quizId}")
    List<Question> getOnlyQuestionsFromQuiz(@PathVariable Long quizId);

    @GetMapping("/question/answers/{quizId}")
    List<Question> getCorrectAnswers(@PathVariable Long quizId);
}

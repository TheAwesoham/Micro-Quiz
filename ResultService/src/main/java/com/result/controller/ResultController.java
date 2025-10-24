package com.result.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.result.entity.Result;
import com.result.service.ResultService;

@RestController
@RequestMapping("/result")
public class ResultController {
    
    private ResultService resultService;

    public ResultController(ResultService resultService) {
        this.resultService = resultService;
    }

    @PostMapping
    public Result saveResult(@RequestBody Result result) {
        return resultService.saveResult(result);
    }

    @GetMapping("/user/{userId}")
    public List<Result> getResultsByUser(@PathVariable Long userId) {
        return resultService.getResultsByUser(userId);
    }

    @GetMapping("/quiz/{quizId}")
    public List<Result> getResultsByQuiz(@PathVariable Long quizId) {
        return resultService.getResultsByQuiz(quizId);
    }
}

package com.result.service;

import java.util.List;

import com.result.entity.Result;

public interface ResultService {
    
    Result saveResult(Result result);

    List<Result> getResultsByUser(Long userId);

    List<Result> getResultsByQuiz(Long quizId);
}

package com.result.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.result.entity.Result;
import com.result.repository.ResultRepository;
import com.result.service.ResultService;

@Service
public class ResultServiceImpl implements ResultService {
    
    private ResultRepository resultRepository;

    public ResultServiceImpl(ResultRepository resultRepository) {
        this.resultRepository = resultRepository;
    }

    @Override
    public Result saveResult(Result result) {
        return resultRepository.save(result);
    }

    @Override
    public List<Result> getResultsByUser(Long userId) {
        return resultRepository.findByUserId(userId);
    }

    @Override
    public List<Result> getResultsByQuiz(Long quizId) {
        return resultRepository.findByQuizId(quizId);
    }
}

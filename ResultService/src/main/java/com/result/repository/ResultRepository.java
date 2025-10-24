package com.result.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.result.entity.Result;

public interface ResultRepository extends JpaRepository<Result, Long> {
    List<Result> findByUserId(Long userId);
    List<Result> findByQuizId(Long quizId);
}

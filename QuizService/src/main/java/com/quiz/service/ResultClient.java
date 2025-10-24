package com.quiz.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.quiz.entity.Result;

@FeignClient(name = "RESULT-SERVICE")
public interface ResultClient {
    @PostMapping("/result")
    Result saveResult(@RequestBody Result result);
}

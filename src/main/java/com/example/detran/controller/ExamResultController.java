package com.example.detran.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.detran.dto.result.ExamResultRequest;
import com.example.detran.dto.result.ExamResultResponse;
import com.example.detran.service.ExamResultService;

@RestController
@RequestMapping("/exam-results")
public class ExamResultController {
    private final ExamResultService examResultService;

    public ExamResultController(ExamResultService examResultService) {
        this.examResultService = examResultService;
    }

    @GetMapping
    public List<ExamResultResponse> findAll() {
        return examResultService.findAll();
    }

    @PostMapping
    public ExamResultResponse create(@RequestBody ExamResultRequest request) {
        return examResultService.create(request);
    }

    @PutMapping("/{id}")
    public ExamResultResponse update(@PathVariable Long id, @RequestBody ExamResultRequest request) {
        return examResultService.update(id, request);
    }

    @GetMapping("/{id}")
    public ExamResultResponse findById(@PathVariable Long id) {
        return examResultService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        examResultService.delete(id);
    }
}

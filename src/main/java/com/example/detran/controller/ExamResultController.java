package com.example.detran.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

import jakarta.validation.Valid;

@RestController
@RequestMapping("/exam-results")
public class ExamResultController {
    private final ExamResultService examResultService;

    public ExamResultController(ExamResultService examResultService) {
        this.examResultService = examResultService;
    }

    @GetMapping
    public ResponseEntity<List<ExamResultResponse>> findAll() {
        return ResponseEntity.ok(examResultService.findAll());
    }

    @PostMapping
    public ResponseEntity<ExamResultResponse> create(@Valid @RequestBody ExamResultRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(examResultService.create(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ExamResultResponse> update(@PathVariable Long id, @Valid @RequestBody ExamResultRequest request) {
        return ResponseEntity.ok(examResultService.update(id, request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExamResultResponse> findById(@PathVariable Long id) {
        return ResponseEntity.ok(examResultService.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        examResultService.delete(id);
        return ResponseEntity.noContent().build();
    }
}

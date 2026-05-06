package com.example.detran.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.detran.dto.exam.ExamRequest;
import com.example.detran.dto.exam.ExamResponse;
import com.example.detran.service.ExamService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/exams")
public class ExamController {
    private final ExamService examService;

    public ExamController(ExamService examService) {
        this.examService = examService;
    }

    @GetMapping
    public ResponseEntity<List<ExamResponse>> findAll() {
        return ResponseEntity.ok(examService.findAll());
    }

    @PostMapping
    public ResponseEntity<ExamResponse> create(@Valid @RequestBody ExamRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(examService.create(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ExamResponse> update(@PathVariable Long id, @Valid @RequestBody ExamRequest request) {
        return ResponseEntity.ok(examService.update(id, request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExamResponse> findById(@PathVariable Long id) {
        return ResponseEntity.ok(examService.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        examService.delete(id);
        return ResponseEntity.noContent().build();
    }

}

package com.example.detran.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.detran.dto.exam.ExamRequest;
import com.example.detran.dto.exam.ExamResponse;
import com.example.detran.service.ExamService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/exams")
public class ExamController {
    private final ExamService examService;

    public ExamController(ExamService examService) {
        this.examService = examService;
    }

    @GetMapping
    public List<ExamResponse> findAll() {
        return examService.findAll();
    }

    @PostMapping
    public ExamResponse create(@RequestBody ExamRequest request) {
        return examService.create(request);
    }

    @PutMapping("/{id}")
    public ExamResponse update(@PathVariable Long id, @RequestBody ExamRequest request) {
        return examService.update(id, request);
    }

    @GetMapping("/{id}")
    public ExamResponse findById(@PathVariable Long id) {
        return examService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        examService.delete(id);
    }

}

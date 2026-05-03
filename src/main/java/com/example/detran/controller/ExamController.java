package com.example.detran.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.detran.model.Exam;
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
    public List<Exam> findAll() {
        return examService.findAll();
    }

    @PostMapping
    public Exam create(@RequestBody Exam exam) {
        return examService.create(exam);
    }

    @PutMapping("/{id}")
    public Exam update(@PathVariable Long id, @RequestBody Exam exam) {
        return examService.update(id, exam);
    }

    @GetMapping("/{id}")
    public Exam findById(@PathVariable Long id) {
        return examService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        examService.delete(id);
    }

}

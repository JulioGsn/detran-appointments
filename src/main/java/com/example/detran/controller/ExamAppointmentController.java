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

import com.example.detran.model.ExamAppointment;
import com.example.detran.service.ExamAppointmentService;

@RestController
@RequestMapping("/exam-appointments")
public class ExamAppointmentController {
    private final ExamAppointmentService examAppointmentService;

    public ExamAppointmentController(ExamAppointmentService examAppointmentService) {
        this.examAppointmentService = examAppointmentService;
    }

    @GetMapping
    public List<ExamAppointment> findAll() {
        return examAppointmentService.findAll();
    }

    @PostMapping
    public ExamAppointment create(@RequestBody ExamAppointment examAppointment) {
        return examAppointmentService.create(examAppointment);
    }

    @PutMapping("/{id}")
    public ExamAppointment update(@PathVariable Long id, @RequestBody ExamAppointment examAppointment) {
        return examAppointmentService.update(id, examAppointment);
    }

    @GetMapping("/{id}")
    public ExamAppointment findById(@PathVariable Long id) {
        return examAppointmentService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        examAppointmentService.delete(id);
    }
}

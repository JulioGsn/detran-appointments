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

import com.example.detran.dto.appointment.ExamAppointmentRequest;
import com.example.detran.dto.appointment.ExamAppointmentResponse;
import com.example.detran.service.ExamAppointmentService;

@RestController
@RequestMapping("/exam-appointments")
public class ExamAppointmentController {
    private final ExamAppointmentService examAppointmentService;

    public ExamAppointmentController(ExamAppointmentService examAppointmentService) {
        this.examAppointmentService = examAppointmentService;
    }

    @GetMapping
    public List<ExamAppointmentResponse> findAll() {
        return examAppointmentService.findAll();
    }

    @PostMapping
    public ExamAppointmentResponse create(@RequestBody ExamAppointmentRequest request) {
        return examAppointmentService.create(request);
    }

    @PutMapping("/{id}")
    public ExamAppointmentResponse update(@PathVariable Long id, @RequestBody ExamAppointmentRequest request) {
        return examAppointmentService.update(id, request);
    }

    @GetMapping("/{id}")
    public ExamAppointmentResponse findById(@PathVariable Long id) {
        return examAppointmentService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        examAppointmentService.delete(id);
    }
}

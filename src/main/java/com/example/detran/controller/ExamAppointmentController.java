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

import com.example.detran.dto.appointment.ExamAppointmentRequest;
import com.example.detran.dto.appointment.ExamAppointmentResponse;
import com.example.detran.service.ExamAppointmentService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/exam-appointments")
public class ExamAppointmentController {
    private final ExamAppointmentService examAppointmentService;

    public ExamAppointmentController(ExamAppointmentService examAppointmentService) {
        this.examAppointmentService = examAppointmentService;
    }

    @GetMapping
    public ResponseEntity<List<ExamAppointmentResponse>> findAll() {
        return ResponseEntity.ok(examAppointmentService.findAll());
    }

    @PostMapping
    public ResponseEntity<ExamAppointmentResponse> create(@Valid @RequestBody ExamAppointmentRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(examAppointmentService.create(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ExamAppointmentResponse> update(@PathVariable Long id, @Valid @RequestBody ExamAppointmentRequest request) {
        return ResponseEntity.ok(examAppointmentService.update(id, request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExamAppointmentResponse> findById(@PathVariable Long id) {
        return ResponseEntity.ok(examAppointmentService.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        examAppointmentService.delete(id);
        return ResponseEntity.noContent().build();
    }
}

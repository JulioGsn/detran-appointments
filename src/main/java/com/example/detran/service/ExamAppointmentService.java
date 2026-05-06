package com.example.detran.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.detran.dto.appointment.ExamAppointmentRequest;
import com.example.detran.dto.appointment.ExamAppointmentResponse;
import com.example.detran.exception.ResourceNotFoundException;
import com.example.detran.mapper.ExamAppointmentMapper;
import com.example.detran.model.Exam;
import com.example.detran.model.ExamAppointment;
import com.example.detran.repository.ExamRepository;
import com.example.detran.repository.ExamAppointmentRepository;

@Service
public class ExamAppointmentService {
    private final ExamAppointmentRepository examAppointmentRepository;
    private final ExamRepository examRepository;

    public ExamAppointmentService(ExamAppointmentRepository examAppointmentRepository, ExamRepository examRepository) {
        this.examAppointmentRepository = examAppointmentRepository;
        this.examRepository = examRepository;
    }

    public ExamAppointmentResponse create(ExamAppointmentRequest request) {
        Exam exam = examRepository.findById(request.getExamId())
            .orElseThrow(() -> new ResourceNotFoundException("Exam not found!"));
        ExamAppointment examAppointment = ExamAppointmentMapper.toEntity(request, exam);
        ExamAppointment savedExamAppointment = examAppointmentRepository.save(examAppointment);
        return ExamAppointmentMapper.toResponse(savedExamAppointment);
    }

    public ExamAppointmentResponse findById(Long id) {
        ExamAppointment examAppointment = examAppointmentRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Exam appointment not found!"));

        return ExamAppointmentMapper.toResponse(examAppointment);
    }

    public List<ExamAppointmentResponse> findAll() {
        return examAppointmentRepository.findAll()
            .stream()
            .map(ExamAppointmentMapper::toResponse)
            .toList();
    }

    public ExamAppointmentResponse update(Long id, ExamAppointmentRequest request) {
        ExamAppointment examAppointmentFound = examAppointmentRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Exam appointment not found!"));
        Exam exam = examRepository.findById(request.getExamId())
            .orElseThrow(() -> new ResourceNotFoundException("Exam not found!"));

        examAppointmentFound.setExam(exam);
        examAppointmentFound.setDate(request.getDate());
        examAppointmentFound.setTime(request.getTime());
        examAppointmentFound.setStatus(request.getStatus());

        ExamAppointment savedExamAppointment = examAppointmentRepository.save(examAppointmentFound);
        return ExamAppointmentMapper.toResponse(savedExamAppointment);
    }

    public void delete(Long id) {
        if(!examAppointmentRepository.existsById(id)) {
            throw new ResourceNotFoundException("Exam appointment not found!");
        }

        examAppointmentRepository.deleteById(id);
    }
}

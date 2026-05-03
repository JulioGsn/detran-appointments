package com.example.detran.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.detran.model.ExamAppointment;
import com.example.detran.repository.ExamAppointmentRepository;

@Service
public class ExamAppointmentService {
    private final ExamAppointmentRepository examAppointmentRepository;

    public ExamAppointmentService(ExamAppointmentRepository examAppointmentRepository) {
        this.examAppointmentRepository = examAppointmentRepository;
    }

    public ExamAppointment create(ExamAppointment examAppointment) {
        return examAppointmentRepository.save(examAppointment);
    }

    public ExamAppointment findById(Long id) {
        return examAppointmentRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Exam appointment not found!"));
    }

    public List<ExamAppointment> findAll() {
        return examAppointmentRepository.findAll();
    }

    public ExamAppointment update(Long id, ExamAppointment examAppointment) {
        ExamAppointment examAppointmentFound = examAppointmentRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Exam appointment not found!"));

        examAppointmentFound.setExam(examAppointment.getExam());
        examAppointmentFound.setDate(examAppointment.getDate());
        examAppointmentFound.setTime(examAppointment.getTime());
        examAppointmentFound.setStatus(examAppointment.getStatus());

        return examAppointmentRepository.save(examAppointmentFound);
    }

    public void delete(Long id) {
        if(!examAppointmentRepository.existsById(id)) {
            throw new RuntimeException("Exam appointment not found!");
        }

        examAppointmentRepository.deleteById(id);
    }
}

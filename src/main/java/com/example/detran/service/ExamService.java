package com.example.detran.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.detran.model.Exam;
import com.example.detran.repository.ExamRepository;

@Service
public class ExamService {
    private final ExamRepository examRepository;

    public ExamService(ExamRepository examRepository) {
        this.examRepository = examRepository;
    }

    public Exam create(Exam exam) {
        return examRepository.save(exam);
    }

    public Exam findById(Long id) {
        return examRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Exam not found!"));
    }

    public List<Exam> findAll() {
        return examRepository.findAll();
    }

    public Exam update(Long id, Exam exam) {
        Exam examFound = examRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Exam not found!"));
        examFound.setCapacity(exam.getCapacity());
        examFound.setDate(exam.getDate());
        examFound.setStart_at(exam.getStart_at());
        examFound.setEnd_at(exam.getEnd_at());

        return examRepository.save(examFound);
    }

    public void delete(Long id) {
        if(!examRepository.existsById(id)) {
            throw new RuntimeException("Exam not found!");
        }

        examRepository.deleteById(id);
    }
}

package com.example.detran.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.detran.model.ExamResult;
import com.example.detran.repository.ExamResultRepository;

@Service
public class ExamResultService {
    private final ExamResultRepository examResultRepository;

    public ExamResultService(ExamResultRepository examResultRepository) {
        this.examResultRepository = examResultRepository;
    }

    public ExamResult create(ExamResult examResult) {
        return examResultRepository.save(examResult);
    }

    public ExamResult findById(Long id) {
        return examResultRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Exam result not found!"));
    }

    public List<ExamResult> findAll() {
        return examResultRepository.findAll();
    }

    public ExamResult update(Long id, ExamResult examResult) {
        ExamResult examResultFound = examResultRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Exam result not found!"));

        examResultFound.setCandidate(examResult.getCandidate());
        examResultFound.setExam(examResult.getExam());
        examResultFound.setResult(examResult.getResult());

        return examResultRepository.save(examResultFound);
    }

    public void delete(Long id) {
        if(!examResultRepository.existsById(id)) {
            throw new RuntimeException("Exam result not found!");
        }

        examResultRepository.deleteById(id);
    }
}

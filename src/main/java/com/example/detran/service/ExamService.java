package com.example.detran.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.detran.dto.exam.ExamRequest;
import com.example.detran.dto.exam.ExamResponse;
import com.example.detran.mapper.ExamMapper;
import com.example.detran.model.Exam;
import com.example.detran.repository.ExamRepository;

@Service
public class ExamService {
    private final ExamRepository examRepository;

    public ExamService(ExamRepository examRepository) {
        this.examRepository = examRepository;
    }

    public ExamResponse create(ExamRequest request) {
        Exam exam = ExamMapper.toEntity(request);
        Exam savedExam = examRepository.save(exam);
        return ExamMapper.toResponse(savedExam);
    }

    public ExamResponse findById(Long id) {
        Exam exam = examRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Exam not found!"));

        return ExamMapper.toResponse(exam);
    }

    public List<ExamResponse> findAll() {
        return examRepository.findAll()
            .stream()
            .map(ExamMapper::toResponse)
            .toList();
    }

    public ExamResponse update(Long id, ExamRequest request) {
        Exam examFound = examRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Exam not found!"));
        examFound.setCapacity(request.getCapacity());
        examFound.setDate(request.getDate());
        examFound.setStart_at(request.getStart_at());
        examFound.setEnd_at(request.getEnd_at());
        examFound.setLicenseCategory(request.getLicenseCategory());

        Exam savedExam = examRepository.save(examFound);
        return ExamMapper.toResponse(savedExam);
    }

    public void delete(Long id) {
        if(!examRepository.existsById(id)) {
            throw new RuntimeException("Exam not found!");
        }

        examRepository.deleteById(id);
    }
}

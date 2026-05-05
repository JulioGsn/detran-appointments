package com.example.detran.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.detran.dto.result.ExamResultRequest;
import com.example.detran.dto.result.ExamResultResponse;
import com.example.detran.mapper.ExamResultMapper;
import com.example.detran.model.Candidate;
import com.example.detran.model.Exam;
import com.example.detran.model.ExamResult;
import com.example.detran.repository.CandidateRepository;
import com.example.detran.repository.ExamRepository;
import com.example.detran.repository.ExamResultRepository;

@Service
public class ExamResultService {
    private final ExamResultRepository examResultRepository;
    private final CandidateRepository candidateRepository;
    private final ExamRepository examRepository;

    public ExamResultService(ExamResultRepository examResultRepository, CandidateRepository candidateRepository, ExamRepository examRepository) {
        this.examResultRepository = examResultRepository;
        this.candidateRepository = candidateRepository;
        this.examRepository = examRepository;
    }

    public ExamResultResponse create(ExamResultRequest request) {
        Candidate candidate = candidateRepository.findById(request.getCandidateId())
            .orElseThrow(() -> new RuntimeException("Candidate not found!"));
        Exam exam = examRepository.findById(request.getExamId())
            .orElseThrow(() -> new RuntimeException("Exam not found!"));
        ExamResult examResult = ExamResultMapper.toEntity(request, candidate, exam);
        ExamResult savedExamResult = examResultRepository.save(examResult);
        return ExamResultMapper.toResponse(savedExamResult);
    }

    public ExamResultResponse findById(Long id) {
        ExamResult examResult = examResultRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Exam result not found!"));

        return ExamResultMapper.toResponse(examResult);
    }

    public List<ExamResultResponse> findAll() {
        return examResultRepository.findAll()
            .stream()
            .map(ExamResultMapper::toResponse)
            .toList();
    }

    public ExamResultResponse update(Long id, ExamResultRequest request) {
        ExamResult examResultFound = examResultRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Exam result not found!"));
        Candidate candidate = candidateRepository.findById(request.getCandidateId())
            .orElseThrow(() -> new RuntimeException("Candidate not found!"));
        Exam exam = examRepository.findById(request.getExamId())
            .orElseThrow(() -> new RuntimeException("Exam not found!"));

        examResultFound.setCandidate(candidate);
        examResultFound.setExam(exam);
        examResultFound.setResult(request.getResult());

        ExamResult savedExamResult = examResultRepository.save(examResultFound);
        return ExamResultMapper.toResponse(savedExamResult);
    }

    public void delete(Long id) {
        if(!examResultRepository.existsById(id)) {
            throw new RuntimeException("Exam result not found!");
        }

        examResultRepository.deleteById(id);
    }
}

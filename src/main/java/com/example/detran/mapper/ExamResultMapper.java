package com.example.detran.mapper;

import com.example.detran.dto.result.ExamResultRequest;
import com.example.detran.dto.result.ExamResultResponse;
import com.example.detran.model.Candidate;
import com.example.detran.model.Exam;
import com.example.detran.model.ExamResult;

public class ExamResultMapper {
    public static ExamResult toEntity(ExamResultRequest request, Candidate candidate, Exam exam) {
        ExamResult examResult = new ExamResult();

        examResult.setCandidate(candidate);
        examResult.setExam(exam);
        examResult.setResult(request.getResult());

        return examResult;
    }

    public static ExamResultResponse toResponse(ExamResult examResult) {
        ExamResultResponse response = new ExamResultResponse();

        response.setId(examResult.getId());
        response.setCandidateId(examResult.getCandidate().getId());
        response.setExamId(examResult.getExam().getId());
        response.setResult(examResult.getResult());

        return response;
    }
}

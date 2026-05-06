package com.example.detran.dto.result;

import com.example.detran.model.enums.ExamResultStatus;

import jakarta.validation.constraints.NotNull;

public class ExamResultRequest {
    @NotNull(message = "Candidate id is required")
    private Long candidateId;

    @NotNull(message = "Exam id is required")
    private Long examId;

    @NotNull(message = "Result is required")
    private ExamResultStatus result;

    public Long getCandidateId() {
        return candidateId;
    }

    public void setCandidateId(Long candidateId) {
        this.candidateId = candidateId;
    }

    public Long getExamId() {
        return examId;
    }

    public void setExamId(Long examId) {
        this.examId = examId;
    }

    public ExamResultStatus getResult() {
        return result;
    }

    public void setResult(ExamResultStatus result) {
        this.result = result;
    }
}

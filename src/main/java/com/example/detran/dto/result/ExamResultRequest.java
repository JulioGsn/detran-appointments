package com.example.detran.dto.result;

import com.example.detran.model.enums.ExamResultStatus;

public class ExamResultRequest {
    private Long candidateId;
    private Long examId;
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

package com.example.detran.dto.result;

import com.example.detran.model.enums.ExamResultStatus;

public class ExamResultResponse {
    private Long id;
    private Long candidateId;
    private Long examId;
    private ExamResultStatus result;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

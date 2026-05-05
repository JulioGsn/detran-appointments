package com.example.detran.mapper;

import com.example.detran.dto.exam.ExamRequest;
import com.example.detran.dto.exam.ExamResponse;
import com.example.detran.model.Exam;

public class ExamMapper {
    public static Exam toEntity(ExamRequest request) {
        Exam exam = new Exam();

        exam.setDate(request.getDate());
        exam.setStart_at(request.getStart_at());
        exam.setEnd_at(request.getEnd_at());
        exam.setLicenseCategory(request.getLicenseCategory());
        exam.setCapacity(request.getCapacity());

        return exam;
    }

    public static ExamResponse toResponse(Exam exam) {
        ExamResponse response = new ExamResponse();

        response.setId(exam.getId());
        response.setDate(exam.getDate());
        response.setStart_at(exam.getStart_at());
        response.setEnd_at(exam.getEnd_at());
        response.setLicenseCategory(exam.getLicenseCategory());
        response.setCapacity(exam.getCapacity());

        return response;
    }
}

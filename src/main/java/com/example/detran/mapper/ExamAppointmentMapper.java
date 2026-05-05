package com.example.detran.mapper;

import com.example.detran.dto.appointment.ExamAppointmentRequest;
import com.example.detran.dto.appointment.ExamAppointmentResponse;
import com.example.detran.model.Exam;
import com.example.detran.model.ExamAppointment;

public class ExamAppointmentMapper {
    public static ExamAppointment toEntity(ExamAppointmentRequest request, Exam exam) {
        ExamAppointment examAppointment = new ExamAppointment();

        examAppointment.setExam(exam);
        examAppointment.setDate(request.getDate());
        examAppointment.setTime(request.getTime());
        examAppointment.setStatus(request.getStatus());

        return examAppointment;
    }

    public static ExamAppointmentResponse toResponse(ExamAppointment examAppointment) {
        ExamAppointmentResponse response = new ExamAppointmentResponse();

        response.setId(examAppointment.getId());
        response.setExamId(examAppointment.getExam().getId());
        response.setDate(examAppointment.getDate());
        response.setTime(examAppointment.getTime());
        response.setStatus(examAppointment.getStatus());

        return response;
    }
}

package com.example.detran.dto.appointment;

import java.time.LocalDate;
import java.time.LocalTime;

import com.example.detran.model.enums.AppointmentStatus;

public class ExamAppointmentRequest {
    private Long examId;
    private LocalDate date;
    private LocalTime time;
    private AppointmentStatus status;

    public Long getExamId() {
        return examId;
    }

    public void setExamId(Long examId) {
        this.examId = examId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public AppointmentStatus getStatus() {
        return status;
    }

    public void setStatus(AppointmentStatus status) {
        this.status = status;
    }
}

package com.example.detran.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.detran.model.ExamAppointment;

public interface ExamAppointmentRepository extends JpaRepository<ExamAppointment, Long> {

}

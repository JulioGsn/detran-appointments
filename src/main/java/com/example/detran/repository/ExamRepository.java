package com.example.detran.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.detran.model.Exam;

public interface ExamRepository extends JpaRepository<Exam, Long>{
    
}

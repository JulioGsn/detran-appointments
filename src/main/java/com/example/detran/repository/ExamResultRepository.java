package com.example.detran.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.detran.model.ExamResult;

public interface ExamResultRepository extends JpaRepository<ExamResult, Long> {
    
}
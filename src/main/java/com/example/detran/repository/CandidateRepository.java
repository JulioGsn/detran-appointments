package com.example.detran.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.detran.model.Candidate;

public interface CandidateRepository extends JpaRepository<Candidate, Long> {
   
}

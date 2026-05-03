package com.example.detran.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.detran.model.Candidate;
import com.example.detran.repository.CandidateRepository;

@Service
public class CandidateService {
    private final CandidateRepository candidateRepository;

    public CandidateService(CandidateRepository candidateRepository) {
        this.candidateRepository = candidateRepository;
    }

    public Candidate create(Candidate candidate) {
        Candidate result = candidateRepository.save(candidate);
        return result;
    }

    public List<Candidate> findAll() {
        List<Candidate> candidates = candidateRepository.findAll();
        return candidates;
    }

    public Candidate findById(Long id) {
        Candidate candidate = candidateRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Candidate not found!"));

        return candidate;
    }

    public Candidate update(Long id, Candidate candidate) {
        Candidate candidateFound = candidateRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Candidate not found!"));

        candidateFound.setName(candidate.getName());
        candidateFound.setEmail(candidate.getEmail());
        
        candidateRepository.save(candidate);
        return candidateFound;
    }

    public void delete(Long id) {
        if(!candidateRepository.existsById(id)) {
            throw new RuntimeException("Candidate not found!");
        }
        candidateRepository.deleteById(id);
    }

}

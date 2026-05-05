package com.example.detran.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.detran.dto.candidate.CandidateRequest;
import com.example.detran.dto.candidate.CandidateResponse;
import com.example.detran.mapper.CandidateMapper;
import com.example.detran.model.Candidate;
import com.example.detran.repository.CandidateRepository;

@Service
public class CandidateService {
    private final CandidateRepository candidateRepository;

    public CandidateService(CandidateRepository candidateRepository) {
        this.candidateRepository = candidateRepository;
    }

    public CandidateResponse create(CandidateRequest request) {
        Candidate candidate = CandidateMapper.toEntity(request);
        Candidate savedCandidate = candidateRepository.save(candidate);
        return CandidateMapper.toResponse(savedCandidate);
    }

    public List<CandidateResponse> findAll() {
        List<CandidateResponse> candidates = candidateRepository.findAll()
            .stream()
            .map(CandidateMapper::toResponse)
            .toList();
            
        return candidates;
    }

    public CandidateResponse findById(Long id) {
        Candidate candidate = candidateRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Candidate not found!"));

        return CandidateMapper.toResponse(candidate);
    }

    public CandidateResponse update(Long id, CandidateRequest request) {
        Candidate candidateFound = candidateRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Candidate not found!"));

        candidateFound.setName(request.getName());
        candidateFound.setEmail(request.getEmail());
        candidateFound.setLicenseCategory(request.getLicenseCategory());
        
        Candidate savedCandidate = candidateRepository.save(candidateFound);
        return CandidateMapper.toResponse(savedCandidate);
    }

    public void delete(Long id) {
        if(!candidateRepository.existsById(id)) {
            throw new RuntimeException("Candidate not found!");
        }
        candidateRepository.deleteById(id);
    }

}

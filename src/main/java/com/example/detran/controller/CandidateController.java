package com.example.detran.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.detran.dto.candidate.CandidateRequest;
import com.example.detran.dto.candidate.CandidateResponse;
import com.example.detran.service.CandidateService;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/candidates")
public class CandidateController {
    private final CandidateService candidateService;

    public CandidateController(CandidateService candidateService) {
        this.candidateService = candidateService;
    }

    @GetMapping()
    public List<CandidateResponse> findAll() {
        return candidateService.findAll();
    }

    @PostMapping
    public CandidateResponse create(@RequestBody CandidateRequest candidate) {
        return candidateService.create(candidate);
    }
    
    @PutMapping("/{id}")
    public CandidateResponse update(@PathVariable Long id, @RequestBody CandidateRequest request) {
        return candidateService.update(id, request);
    }

    @GetMapping("/{id}")
    public CandidateResponse findById(@PathVariable Long id) {
        return candidateService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        candidateService.delete(id);
    }
}

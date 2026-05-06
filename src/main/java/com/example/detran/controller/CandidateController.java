package com.example.detran.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.detran.dto.candidate.CandidateRequest;
import com.example.detran.dto.candidate.CandidateResponse;
import com.example.detran.service.CandidateService;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/candidates")
public class CandidateController {
    private final CandidateService candidateService;

    public CandidateController(CandidateService candidateService) {
        this.candidateService = candidateService;
    }

    @GetMapping()
    public ResponseEntity<List<CandidateResponse>> findAll() {
        return ResponseEntity.ok(candidateService.findAll());
    }

    @PostMapping
    public ResponseEntity<CandidateResponse> create(@Valid @RequestBody CandidateRequest candidate) {
        return ResponseEntity.status(HttpStatus.CREATED).body(candidateService.create(candidate));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<CandidateResponse> update(@PathVariable Long id, @Valid @RequestBody CandidateRequest request) {
        return ResponseEntity.ok(candidateService.update(id, request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CandidateResponse> findById(@PathVariable Long id) {
        return ResponseEntity.ok(candidateService.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        candidateService.delete(id);
        return ResponseEntity.noContent().build();
    }
}

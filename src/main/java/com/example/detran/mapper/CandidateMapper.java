package com.example.detran.mapper;

import com.example.detran.dto.candidate.CandidateRequest;
import com.example.detran.dto.candidate.CandidateResponse;
import com.example.detran.model.Candidate;

public class CandidateMapper {
    public static Candidate toEntity(CandidateRequest request) {
        Candidate candidate = new Candidate();

        candidate.setName(request.getName());
        candidate.setEmail(request.getEmail());
        candidate.setLicenseCategory(request.getLicenseCategory());

        return candidate;
    }

    public static CandidateResponse toResponse(Candidate candidate) {
        CandidateResponse response = new CandidateResponse();

        response.setId(candidate.getId());
        response.setName(candidate.getName());
        response.setEmail(candidate.getEmail());
        response.setLicenseCategory(candidate.getLicenseCategory());

        return response;
    }
}

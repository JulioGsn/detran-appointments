package com.example.detran.dto.candidate;

import com.example.detran.model.enums.LicenseCategory;

public class CandidateResponse {
    private Long id;
    private String name;
    private String email;
    private LicenseCategory licenseCategory;
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public LicenseCategory getLicenseCategory() {
        return licenseCategory;
    }
    public void setLicenseCategory(LicenseCategory licenseCategory) {
        this.licenseCategory = licenseCategory;
    }

    
}

package com.example.detran.dto.candidate;

import com.example.detran.model.enums.LicenseCategory;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class CandidateRequest {
    @NotBlank(message = "Name is required")
    @Size(min = 3, max = 120, message = "Name must have between 3 and 120 characters")
    private String name;

    @NotBlank(message = "Email is required")
    @Email(message = "Email must be valid")
    private String email;

    @NotNull(message = "License category is required")
    private LicenseCategory licenseCategory;

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

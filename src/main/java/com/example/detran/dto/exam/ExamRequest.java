package com.example.detran.dto.exam;

import java.time.LocalDate;
import java.time.LocalTime;

import com.example.detran.model.enums.LicenseCategory;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class ExamRequest {
    @NotNull(message = "Date is required")
    private LocalDate date;

    @NotNull(message = "Start time is required")
    private LocalTime start_at;

    @NotNull(message = "End time is required")
    private LocalTime end_at;

    @NotNull(message = "License category is required")
    private LicenseCategory licenseCategory;

    @NotNull(message = "Capacity is required")
    @Min(value = 1, message = "Capacity must be at least 1")
    private Integer capacity;

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getStart_at() {
        return start_at;
    }

    public void setStart_at(LocalTime start_at) {
        this.start_at = start_at;
    }

    public LocalTime getEnd_at() {
        return end_at;
    }

    public void setEnd_at(LocalTime end_at) {
        this.end_at = end_at;
    }

    public LicenseCategory getLicenseCategory() {
        return licenseCategory;
    }

    public void setLicenseCategory(LicenseCategory licenseCategory) {
        this.licenseCategory = licenseCategory;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }
}

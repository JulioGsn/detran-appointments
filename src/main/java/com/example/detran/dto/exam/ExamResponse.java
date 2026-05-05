package com.example.detran.dto.exam;

import java.time.LocalDate;
import java.time.LocalTime;

import com.example.detran.model.enums.LicenseCategory;

public class ExamResponse {
    private Long id;
    private LocalDate date;
    private LocalTime start_at;
    private LocalTime end_at;
    private LicenseCategory licenseCategory;
    private Integer capacity;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

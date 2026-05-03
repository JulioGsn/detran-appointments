package com.example.detran.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import com.example.detran.model.enums.LicenseCategory;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "exams")
public class Exam {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "exam")
    private List<ExamAppointment> examAppointments = new ArrayList<>();

    @OneToMany(mappedBy = "exam")
    private List<ExamResult> examResults = new ArrayList<>();

    @Column(nullable = false)
    private LocalDate date;

    @Column(nullable = false)
    private LocalTime start_at;

    @Column(nullable = false)
    private LocalTime end_at;

    @Enumerated(EnumType.STRING)
    private LicenseCategory licenseCategory = LicenseCategory.CATEGORYAB;

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

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }
}

package com.example.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class TrafficTrial {

    @Id
    private String id;
    private String initDate;
    private String endingDate;
    private double budget;
    private String mainInvestigator;
    private int qty;
    private String status;
    private String description;

    @OneToMany(targetEntity= Enrollment.class, mappedBy = "trafficTrial", cascade = CascadeType.ALL,  fetch= FetchType.LAZY)
    private List<Enrollment> enrollments = new ArrayList<>();

    public void addEnrollment(Enrollment enrollment) {
        this.getEnrollments().add(enrollment);
        enrollment.setTrafficTrial(this);
    }
}

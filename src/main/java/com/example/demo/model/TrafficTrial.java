package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "TRAFFIC_TRIAL_UNIVERSITY_FKS",
            joinColumns = @JoinColumn(name = "TRAFFIC_TRIAL_FK"),
            inverseJoinColumns = @JoinColumn(name = "UNIVERSITY_FK"))
    private List<University> universities = new ArrayList<>();

    public void addEnrollment(Enrollment enrollment) {
        this.getEnrollments().add(enrollment);
        enrollment.setTrafficTrial(this);
    }
}

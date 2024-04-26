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
public class University {
    @Id
    private String id;
    private String universityName;
    private String department;
    private  int yearFoundation;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<TrafficTrial> trafficTrials = new ArrayList<>();

    public void addTrafficTrial(TrafficTrial trafficTrial) {
        this.getTrafficTrials().add(trafficTrial);

    }
}

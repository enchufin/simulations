package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Enrollment {

    @Id
    private String id;
    private String joinDate;
    private double salary;
    private String status;
    private boolean isActive;
    @JsonIgnore
    @ManyToOne(targetEntity=Player.class,fetch = FetchType.LAZY)
    @JoinColumn(name="PLAYER_FK", nullable = false)
    public Player player;

    @JsonIgnore
    @ManyToOne(targetEntity=TrafficTrial.class, fetch = FetchType.LAZY)
    @JoinColumn(name="TRAFFIC_TRIAL_FK", nullable = false)
    public TrafficTrial trafficTrial;
}

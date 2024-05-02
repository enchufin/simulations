package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@NoArgsConstructor @AllArgsConstructor
@Entity
public class Payment {

    @Id
    private String id;
    private String date;
    private double cost;
    private String concept;
    private boolean isPaid;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="PLAYER_FK")
    private Player player;

}

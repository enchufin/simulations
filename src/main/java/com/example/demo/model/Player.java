package com.example.demo.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.ArrayList;
import java.util.List;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Player {

    @Id
    private String id;
    private String player;
    private int age;
    private boolean active;

    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL)
    private List<Simulation> simulations = new ArrayList<>();

    public void addSimulation(Simulation simulation) {
        this.getSimulations().add(simulation);
        //if (simulation.getId() != null) simulation.getId().getSimulations().remove(simulation);
        simulation.setPlayer(this);
    }
}

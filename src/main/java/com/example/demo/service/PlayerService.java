package com.example.demo.service;

import com.example.demo.model.Simulation;
import com.example.demo.model.Player;
import com.example.demo.repository.PlayerRepository;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PlayerService {


    @Autowired
    PlayerRepository playerRepository;

    @Autowired
    SimulationService simulationService;


    public void populate() {

        // locale in english
        Faker faker = new Faker(new Locale("en-GB"));

        List<Simulation> simulations;
        //Date date = new Date();

        // ref variable creation UUID
        String uniqueID;

        for (int i = 0; i <10 ; i++ ){
            simulations = simulationService.populate();
            uniqueID = UUID.randomUUID().toString();
            Player player =  new Player(   uniqueID,
                    faker.artist().name(),
                    faker.number().numberBetween(10, 100),
                    true,
                    simulations);
            playerRepository.save(player
                             );


        }
    }
}

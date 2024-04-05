package com.example.demo.service;
import com.example.demo.model.Simulation;
import com.example.demo.repository.SimulationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.javafaker.Faker;

import java.util.*;


@Service
public class SimulationService {

    //static ArrayList<Simulation> simulations = new ArrayList<>();

    @Autowired
    SimulationRepository simulationRepository;


    public List<Simulation> populate() {

        // locale in english
        Faker faker = new Faker(new Locale("en-GB"));
        Date date = new Date();
        List<Simulation> simulations = new ArrayList<>();

        // ref variable creation UUID
        String uniqueID;

        for (int i = 0; i <10 ; i++ ){

            uniqueID = UUID.randomUUID().toString();
            Simulation simulation = new Simulation( uniqueID,
                    date.toString(),
                    faker.number().numberBetween(100, 1250),
                    faker.artist().name() );

            simulationRepository.save(simulation);
            simulations.add(simulation);


        }

        return simulations;
    }
}

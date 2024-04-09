package com.example.demo.service;

import com.example.demo.model.Simulation;
import com.example.demo.model.Player;
import com.example.demo.model.Social;
import com.example.demo.repository.PlayerRepository;
import com.example.demo.repository.SimulationRepository;
import com.example.demo.repository.SocialRepository;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PlayerService {


    @Autowired
    PlayerRepository playerRepository;
    @Autowired
    SocialRepository socialRepository;
    @Autowired
    SimulationService simulationService;
    @Autowired
    SocialService socialService;


    public void populate() {

        // locale in english
        Faker faker = new Faker(new Locale("en-GB"));

        List<Simulation> simulations;
        List<Social> socials;
        //Date date = new Date();

        // ref variable creation UUID
        String uniqueID;

        for (int i = 0; i <10 ; i++ ){

            uniqueID = UUID.randomUUID().toString();
            Player player =  new Player();
            player.setId(uniqueID);
            player.setActive(true);
            player.setPlayer( faker.artist().name());
            player.setAge(faker.number().numberBetween(10, 100));

            simulations = simulationService.createFakeSimulations();
            socials = socialService.createFakeSocials();

            for (int j = 0; j <10 ; j++ ) {
                player.addSimulation(simulations.get(j));
            }
            //int numSocial = (int)(socialRepository.count() -1);
           int qtySocial = socials.size();

            for (int j = 0; j < (qtySocial -1) ; j++ ) {
                player.addSocial(socials.get(j));
            }


            playerRepository.save(player);

        }
    }
}

package com.example.demo.service;

import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PlayerService {
    @Autowired
    TrafficTrialRepository trafficTrialRepository;
    @Autowired
    PlayerRepository playerRepository;
    @Autowired
    SimulationService simulationService;
    @Autowired
    SocialService socialService;
    @Autowired
    CardService cardService;
    @Autowired
    PaymentService paymentService;
    @Autowired
    SubscriptionService subscriptionService;


    public void populate() {

        // locale in english
        Faker faker = new Faker(new Locale("en-GB"));

        List<Simulation> simulations;
        List<Social> socials;
        List<Card> cards;
        List<Payment> payments;
        List<Subscription> subscriptions;

        // ref variable creation UUID
        String uniqueID;

        for (int i = 0; i <10 ; i++ ){

            uniqueID = UUID.randomUUID().toString();
            Player player =  new Player();
            player.setId(uniqueID);
            player.setActive(true);
            player.setPlayer( faker.artist().name());
            player.setAge(faker.number().numberBetween(10, 100));

            subscriptions = subscriptionService.createFakeSubscriptions();
            simulations = simulationService.createFakeSimulations();
            socials = socialService.createFakeSocials();
            payments = paymentService.createFakePayments();
            cards = cardService.createFakeCards();


            // add simulations to EACH player
            for (int j = 0; j <10 ; j++ ) {
                player.addSimulation(simulations.get(j));
                player.addSubscription(subscriptions.get(j));
            }

            // add payments to EACH player
            for (int j = 0; j <10 ; j++ ) {
                player.addPayment(payments.get(j));
            }

            // add cards to EACH player
            for (int j = 0; j <10 ; j++ ) {
                player.addCard(cards.get(j));
            }

            //int numSocial = (int)(socialRepository.count() -1);
           int qtySocial = socials.size();

            // add SOCIAL to EACH player
            for (int j = 0; j < (qtySocial -1) ; j++ ) {
                player.addSocial(socials.get(j));
            }


            // eventually we SAVE data (PLAYER + ...) to DB H2 by JPA
            playerRepository.save(player);

        }
    }
}

package com.example.demo.service;
import com.example.demo.model.Card;
import com.example.demo.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.javafaker.Faker;

import java.util.*;


@Service
public class CardService {

    //static ArrayList<Simulation> simulations = new ArrayList<>();

    @Autowired
    CardRepository cardRepository;

    public List<Card> createFakeCards() {

        // locale in english
        Faker faker = new Faker(new Locale("en-GB"));
        Date date = new Date();
        List<Card> cards = new ArrayList<>();

        // ref variable creation UUID
        String uniqueID;

        for (int i = 0; i <10 ; i++ ){

            uniqueID = UUID.randomUUID().toString();
            Card card= new Card( uniqueID,
                    faker.number().numberBetween(10000,50000),
                    faker.number().numberBetween(100,150),
                    faker.number().numberBetween(2024,2030),
                    true, null
            );
            cards.add(card);
        }

        return cards;
    }

    public List<Card> populate() {

        List<Card> cards = createFakeCards();

        for (int i = 0; i <5 ; i++ ){
            cardRepository.save(cards.get(i));
            cards.add(cards.get(i));
        }

        return cards;
    }


}

package com.example.demo.service;
import com.example.demo.model.Simulation;
import com.example.demo.model.Social;
import com.example.demo.repository.SocialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.javafaker.Faker;

import java.util.*;


@Service
public class SocialService {

    //static ArrayList<Simulation> simulations = new ArrayList<>();

    @Autowired
    SocialRepository socialRepository;

    public List<Social> createFakeSocials() {
        Faker faker = new Faker(new Locale("es-ES"));
        List<Social> socials = new ArrayList<>();

        // ref variable creation UUID
        String uniqueID;
        int num = (int) ((Math.random() * (5 - 1)) + 1);

        for (int i = 0; i <num ; i++ ){

            uniqueID = UUID.randomUUID().toString();
            Social social = new Social( uniqueID,
                    faker.name().firstName(),
                    true,
                    faker.number().numberBetween(1,365),
                    faker.internet().url(),
                    faker.internet().avatar(), null);

            socials.add(social);
        }
        return socials;
        }

    public List<Social> populate() {

        List<Social> socials = createFakeSocials();
        int qtySocial = socials.size();

        for (int i = 0; i < (qtySocial -1) ; i++ ){
            socialRepository.save(socials.get(i));
            socials.add(socials.get(i));
        }

        return socials;
    }


}

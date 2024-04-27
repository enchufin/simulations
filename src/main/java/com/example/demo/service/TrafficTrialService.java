package com.example.demo.service;

import com.example.demo.repository.UniversityRepository;
import com.example.demo.service.UniversityService;
import com.example.demo.model.TrafficTrial;
import com.example.demo.model.University;
import com.example.demo.repository.TrafficTrialRepository;
import com.github.javafaker.Faker;
import jakarta.persistence.AttributeOverride;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class TrafficTrialService {

    @Autowired
    TrafficTrialRepository trafficTrialRepository;
    @Autowired
    UniversityRepository universityRepository;
    @Autowired
    UniversityService universityService;

    public List<TrafficTrial> createFakeTrafficTrials() {

        // locale in english
        Faker faker = new Faker(new Locale("en-GB"));
        Date date = new Date();
        List<TrafficTrial> trafficTrials = new ArrayList<>();

        // ref variable creation UUID
        String uniqueID;

        for (int i = 0; i <5 ; i++ ){
            uniqueID = UUID.randomUUID().toString();
            TrafficTrial trafficTrial= new TrafficTrial();
            trafficTrial.setId(uniqueID);
            trafficTrial.setInitDate(date.toString());
            trafficTrial.setEndingDate(date.toString());
            trafficTrial.setBudget(faker.number().randomDouble(2,10000,50000));
            trafficTrial.setMainInvestigator(faker.name().fullName().toString());
            trafficTrial.setQty(14);
            trafficTrial.setStatus("IN-PROGRESS");
            trafficTrial.setDescription("description");

            trafficTrials.add(trafficTrial);
        }

        return trafficTrials;
    }

    public List<TrafficTrial> populate() {

        List<TrafficTrial> trafficTrials = createFakeTrafficTrials();

        List<University> universitys = universityService.createFakeUniversitys();

        for (TrafficTrial tt: trafficTrials){
            trafficTrialRepository.save(tt);
            for (University uni: universitys){
                universityRepository.save(uni);
                tt.addUniversity(uni);
                trafficTrialRepository.save(tt);
            }

        }
        return trafficTrials;
    }

}

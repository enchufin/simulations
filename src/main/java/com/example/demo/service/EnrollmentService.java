package com.example.demo.service;

import com.example.demo.model.Enrollment;
import com.example.demo.model.Player;
import com.example.demo.model.TrafficTrial;
import com.example.demo.repository.EnrollmentRepository;
import com.example.demo.repository.PlayerRepository;
import com.example.demo.repository.TrafficTrialRepository;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;


@Service
public class EnrollmentService {


    @Autowired
    EnrollmentRepository enrollmentRepository;
    @Autowired
    PlayerRepository playerRepository;
    @Autowired
    TrafficTrialRepository trafficTrialRepository;

    public List<Enrollment> createFakeEnrollments() {

        // locale in english
        Faker faker = new Faker(new Locale("en-GB"));
        Date date = new Date();

        List<Enrollment> enrollments = new ArrayList<>();
        Iterable<Player> players = playerRepository.findAll();
        Iterable<TrafficTrial> trafficTrials = trafficTrialRepository.findAll();

        // ref variable creation UUID
        String uniqueID;

        for (Player player : players){

            //int trafficTrialQtyByPlayer = faker.number().numberBetween(1,5);
            //for (int i = 0; i < trafficTrialQtyByPlayer; i++) {
            for (TrafficTrial trafficTrial : trafficTrials){

                uniqueID = UUID.randomUUID().toString();
                Enrollment enrollment = new Enrollment();

                enrollment.setId(uniqueID);
                enrollment.setJoinDate(date.toString());
                enrollment.setSalary(faker.number().randomDouble(2, 1000, 3000));
                enrollment.setStatus("IN-PROGRESS");
                enrollment.setActive(true);

                enrollment.setPlayer(player);
                enrollment.setTrafficTrial(trafficTrial);

                enrollments.add(enrollment);
            }
        }


        return enrollments;
    }

    public List<Enrollment> populate() {

        List<Enrollment> enrollments = createFakeEnrollments();

        for (Enrollment enrollment : enrollments){
            enrollmentRepository.save(enrollment);
        }

        return enrollments;
    }


}

package com.example.demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.javafaker.Faker;
import java.util.Date;
import java.util.Locale;
import java.util.UUID;


@Service
public class SimulationService {

    //static ArrayList<Simulation> simulations = new ArrayList<>();

    @Autowired
    SimulationRepository simulationRepository;

    public Iterable<Simulation> getAllSimulations (){

        return  simulationRepository.findAll();
    }


    public void populate() {

        // locale in english
        Faker faker = new Faker(new Locale("en-GB"));
        Date date = new Date();

        // ref variable creation UUID
        String uniqueID;

        for (int i = 0; i <10 ; i++ ){

            uniqueID = UUID.randomUUID().toString();
            simulationRepository.save(
                    new Simulation ( uniqueID,
                            date.toString(),
                            faker.number().numberBetween(100, 1250),
                            faker.artist().name() ));


        }
    }
}

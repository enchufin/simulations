package com.example.demo.service;

import com.example.demo.model.University;
import com.example.demo.repository.UniversityRepository;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
@Service
public class UniversityService {
    @Autowired
    UniversityRepository universityRepository;


    public List<University> createFakeUniversitys() {

        // locale in english
        Faker faker = new Faker(new Locale("en-GB"));
        Date date = new Date();
        List<University> universitys = new ArrayList<>();

        // ref variable creation UUID
        String uniqueID;

        for (int i = 0; i <6 ; i++ ){

            uniqueID = UUID.randomUUID().toString();
            University university= new University(
                    uniqueID,
                    faker.university().name().toString(),
                    "Traffic and Urbanism",
                    faker.number().numberBetween(1850,1959),
                    new ArrayList<>()
            );
            universitys.add(university);
        }

        return universitys;
    }

    public List<University> populate() {

        List<University> universitys = createFakeUniversitys();
        int qtyUniversitys = universitys.size();


        for (int i = 0; i < qtyUniversitys ; i++ ){

            universityRepository.save(universitys.get(i));

        }

        return universitys;
    }


}

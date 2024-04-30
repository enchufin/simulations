package com.example.demo.service;

import com.example.demo.model.ImagePlayer;
import com.example.demo.repository.ImagePlayerRepository;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ImagePlayerService {

    @Autowired
    ImagePlayerRepository imagePlayerRepository;


    public List<ImagePlayer> findAllImages (){
        return imagePlayerRepository.findAll();
    }

    public Optional<ImagePlayer> findById (String id){
        return imagePlayerRepository.findById(id);
    }

    public ImagePlayer createImagePlayer (ImagePlayer imagePlayer){
        return imagePlayerRepository.save(imagePlayer);
    }

    public void deleteAll (){
        imagePlayerRepository.deleteAll();
    }

    public void deleteById (String id){
        imagePlayerRepository.deleteById(id);
    }

    // to-do: update ImagePlayer

    public List<ImagePlayer> populate (){

        List<ImagePlayer> imagePlayers = new ArrayList<>();

        Faker faker = new Faker();

        for (int i= 0; i < 10; i++){

            ImagePlayer imagePlayer = new ImagePlayer();
            imagePlayer.setId( UUID.randomUUID().toString());
            imagePlayer.setNameImage(faker.funnyName().name());
            imagePlayer.setType("BYTE RAW BASE64");
            imagePlayer.setSize(faker.number().randomDouble(2, 100, 300));

            imagePlayers.add(imagePlayer);
            imagePlayerRepository.save(imagePlayer);


        }

        return imagePlayers;

    }

}

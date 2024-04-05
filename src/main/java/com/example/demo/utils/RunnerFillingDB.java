package com.example.demo.utils;


import com.example.demo.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;


@Component
public class RunnerFillingDB implements ApplicationRunner {
    @Autowired
    PlayerService playerService;
    @Override
    public void run(ApplicationArguments args) throws Exception {



       // simulationService.populate();
        playerService.populate();


    }
}

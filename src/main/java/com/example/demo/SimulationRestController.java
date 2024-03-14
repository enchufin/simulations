package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/simulation/")
public class SimulationRestController {

    @Autowired
    SimulationService simulationService;

    @RequestMapping("/hello")
    public String HelloWorld (){


        return "This is a sandbox for my first java class controller";

    }


    @RequestMapping("/simulations")
    public Iterable<Simulation> getAllSimulations (){

        return simulationService.getAllSimulations();

    }

    @RequestMapping("/populate")
    public String populateDB(){

        simulationService.populate();

        return "ok";
    }





}

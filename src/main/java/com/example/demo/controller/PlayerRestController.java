package com.example.demo.controller;

import com.example.demo.model.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.repository.PlayerRepository;

import java.util.List;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/player/")
public class PlayerRestController {

    @Autowired
    PlayerRepository playerRepository;

    //CRUD: read
    @RequestMapping("/players")
    public Iterable<Player> getAllUsers (){

        return playerRepository.findAll();

    }
}

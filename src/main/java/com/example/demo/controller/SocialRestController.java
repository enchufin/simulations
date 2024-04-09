package com.example.demo.controller;

import com.example.demo.model.Social;
import com.example.demo.model.Social;
import com.example.demo.repository.SocialRepository;
import com.example.demo.service.SimulationService;
import com.example.demo.service.SocialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/social/")
public class SocialRestController {


    @Autowired
    SocialService socialService;
    @Autowired
    SocialRepository socialRepository;

    //CRUD: read
    @RequestMapping("/socials")
    public Iterable<Social> getAllSocials (){

        return socialRepository.findAll();

    }

    //CRUD: delete
    @DeleteMapping("/delete")
    public String deleteSocial(@RequestParam String id) {

        //System.out.println("id:" + id);
        Optional<Social> socialFound = socialRepository.findById(id);
        long countBefore = socialRepository.count();
        //System.out.println("simulationFound:" + simulationFound);

        if (socialFound.isPresent()){
            socialRepository.deleteById(id);
            long countAfter = socialRepository.count();
            String response = "social deleted: " + id + " count: " + countBefore + "/" + countAfter;
            return response;
        } else return "id: " + id +  " not found " + " count: " + countBefore;

    }

    //CRUD: create
    @PostMapping(path="create", consumes = "application/JSON")
    public Social createSocial(@RequestBody Social social){
        //
        Social socialCreated = socialRepository.save(social);
        return socialCreated;
    }

    //CRUD: update
    @PutMapping("/update/{id}")
    public Social updateSocial (@PathVariable String id, @RequestBody Social social) {

        Optional<Social> socialFound = socialRepository.findById(id);

        if (socialFound.isPresent()) {
            Social socialToUpdate = socialFound.get();
            //
            if  (social.isActive()) {
                socialToUpdate.setName(social.getName());
                socialToUpdate.setNumberDays(social.getNumberDays());
                socialToUpdate.setSocialUrl(social.getSocialUrl());
                socialToUpdate.setIcon(social.getIcon());
            }

            Social socialUpdated = socialRepository.save(socialToUpdate);
            return socialUpdated;
        } else
            return null;

    }

    @RequestMapping("/populate")
    public String populateDB(){

        socialService.populate();

        return "ok";
    }

}

package com.example.demo.controller;

import com.example.demo.model.Card;
import com.example.demo.model.Simulation;
import com.example.demo.repository.CardRepository;
import com.example.demo.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/card/")
public class CardRestController {

    @Autowired
    CardService cardService;

    @Autowired
    CardRepository cardRepository;


    //CRUD: read
    @RequestMapping("/cards")
    public Iterable<Card> getAllCards() {

        return cardRepository.findAll();

    }

    //CRUD: delete
    @DeleteMapping("/delete")
    public String deleteCard(@RequestParam String id) {

        //System.out.println("id:" + id);
        Optional<Card> cardFound = cardRepository.findById(id);
        long countBefore = cardRepository.count();
        //System.out.println("simulationFound:" + simulationFound);

        if (cardFound.isPresent()) {
            cardRepository.deleteById(id);
            long countAfter = cardRepository.count();
            String response = "card deleted: " + id + " count: " + countBefore + "/" + countAfter;
            return response;
        } else return "id: " + id + " not found " + " count: " + countBefore;

    }

    //CRUD: create
    @PostMapping(path = "create", consumes = "application/JSON")
    public Card createCard(@RequestBody Card card) {
        //
        Card cardCreated = cardRepository.save(card);
        return cardCreated;
    }

    //CRUD: update
    @PutMapping("/update/{id}")
    public Card updateCard (@PathVariable String id, @RequestBody Card card) {

        Optional<Card> cardFound = cardRepository.findById(id);

        if (cardFound.isPresent()) {
            Card cardToUpdate = cardFound.get();
            //
            if  (card.getExpDate() > 0) {
                cardToUpdate.setExpDate(card.getExpDate());
            }

            Card cardUpdated = cardRepository.save(cardToUpdate);
            return cardUpdated;
        } else
            return null;

    }




        @RequestMapping("/populate")
        public String populateDB () {

            cardService.populate();

            return "ok";
        }


    }
package com.example.demo.repository;

import com.example.demo.model.ImagePlayer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ImagePlayerRepository  extends MongoRepository<ImagePlayer, String> {

    //WE SHOULD MAKE SOME DERIVATED QUERYS
}

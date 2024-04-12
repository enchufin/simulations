package com.example.demo.repository;

import com.example.demo.model.Card;
import org.springframework.data.repository.CrudRepository;

public interface CardRepository extends CrudRepository<Card, String> {
}
package com.example.demo.repository;


import com.example.demo.model.University;
import org.springframework.data.repository.CrudRepository;

public interface UniversityRepository extends CrudRepository<University, String> {
}

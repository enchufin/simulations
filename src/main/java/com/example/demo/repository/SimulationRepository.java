package com.example.demo.repository;

import com.example.demo.model.Simulation;
import org.springframework.data.repository.CrudRepository;

public interface SimulationRepository extends CrudRepository<Simulation, String> {}
package com.example.demo.repository;

import com.example.demo.model.Payment;
import com.example.demo.model.Simulation;
import org.springframework.data.repository.CrudRepository;

public interface PaymentRepository extends CrudRepository<Payment, String> {}

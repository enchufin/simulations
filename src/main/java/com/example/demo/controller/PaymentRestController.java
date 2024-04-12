package com.example.demo.controller;

import com.example.demo.model.Payment;
import com.example.demo.model.Simulation;
import com.example.demo.repository.PaymentRepository;
import com.example.demo.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/payment/")
public class PaymentRestController {

    @Autowired
    PaymentService paymentService;

    @Autowired
    PaymentRepository paymentRepository;

    //CRUD: read
    @RequestMapping("/payments")
    public Iterable<Payment> getAllPayments (){

        return paymentRepository.findAll();

    }

    //CRUD: create
    @PostMapping(path="create", consumes = "application/JSON")
    public Payment createPayment(@RequestBody Payment payment){
        //
        Payment paymentCreated = paymentService.createPayment(payment);
        return paymentCreated;
    }
}

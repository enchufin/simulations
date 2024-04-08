package com.example.demo.controller;

import com.example.demo.model.Payment;
import com.example.demo.repository.PaymentRepository;
import com.example.demo.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

public class PaymentRestController {

    @Autowired
    PaymentService paymentService;

    @Autowired
    PaymentRepository paymentRepository;

    //CRUD: read
    @RequestMapping("/simulations")
    public Iterable<Payment> getAllPayments (){

        return paymentRepository.findAll();

    }

}

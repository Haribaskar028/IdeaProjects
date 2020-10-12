package com.learn.elastic.controller;

import com.learn.elastic.module.Customer;
import com.learn.elastic.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ElasticController {
    @Autowired
    private CustomerRepository customerRepository;

    @PostMapping("/save")
    public int saveCustomer(@RequestBody  List<Customer> customers){
        customerRepository.saveAll(customers);
        return customers.size();
    }

    @GetMapping("/customers")
    public Iterable<Customer> getCustomers(){
        return  customerRepository.findAll();
    }

    @GetMapping("/customer/{firstname}")
    public List<Customer> getCustomer(@PathVariable String firstname){
        return customerRepository.findByFirstname(firstname);
    }

}

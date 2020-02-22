package com.sys.billing.controllers;

import com.sys.billing.models.Customer;
import com.sys.billing.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerController(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }

    @PostMapping()
    public String addCustomers(@RequestBody List<Customer> customers){
        customerRepository.saveAll(customers);
        return "Successfully added";
    }

    @GetMapping()
    public List<Customer> getAllCustomers(){
        return customerRepository.findAll();
    }

    @PutMapping
    public String updateCustomer(@RequestBody final Customer customer){
        customerRepository.save(customer);
        return "Successfully updated";
    }
}

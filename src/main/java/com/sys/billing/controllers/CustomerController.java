package com.sys.billing.controllers;

import com.sys.billing.models.Customer;
import com.sys.billing.repositories.CustomerRepository;
import com.sys.billing.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    private CustomerService customerService;

    @Autowired
    CustomerController(CustomerService customerService){
        this.customerService = customerService;
    }

    @PostMapping()
    ResponseEntity<String> addCustomers(@Valid @RequestBody List<Customer> customers){
        return new ResponseEntity<String>(customerService.saveCustomers(customers), HttpStatus.OK);
    }

    @GetMapping()
    ResponseEntity<List<Customer>> getAllCustomers(){
        return new ResponseEntity<List<Customer>>(customerService.getAllCustomers(), HttpStatus.OK);
    }

    @PutMapping()
    ResponseEntity<String> updateCustomerInfo(@Valid @RequestBody final Customer customer){
        return new ResponseEntity<String>(customerService.updateCustomerInfo(customer), HttpStatus.OK);
    }
}

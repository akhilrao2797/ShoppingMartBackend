package com.sys.billing.controllers;

import com.sys.billing.models.Bill;
import com.sys.billing.services.BillingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/bill")
public class BillingController {

    @Autowired
    private BillingService billService;

    @PostMapping()
    ResponseEntity<Bill> saveBill(@Valid @RequestBody final Bill bill){
        return new ResponseEntity<Bill>(billService.saveBill(bill), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    ResponseEntity<Bill> getBillById(@PathVariable("id") final Long id){
        return new ResponseEntity<Bill>(billService.getBill(id), HttpStatus.OK);
    }
}

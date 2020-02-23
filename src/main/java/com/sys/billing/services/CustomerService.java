package com.sys.billing.services;

import com.sys.billing.models.Customer;
import com.sys.billing.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public String saveCustomers(List<Customer> customers) {
        customerRepository.saveAll(customers);
        return "Successfully added";
    }

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public String updateCustomerInfo(Customer customer) {
        customerRepository.save(customer);
        return "Successfully updated";
    }
}

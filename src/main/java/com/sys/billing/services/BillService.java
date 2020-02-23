package com.sys.billing.services;

import com.sys.billing.models.Bill;
import com.sys.billing.repositories.BillingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BillService {

    @Autowired
    private BillingRepository billingRepository;

    public Bill saveBill(Bill bill) {
        return billingRepository.save(bill);
    }

    public Bill getBill(Long id) {
        return null;
    }
}

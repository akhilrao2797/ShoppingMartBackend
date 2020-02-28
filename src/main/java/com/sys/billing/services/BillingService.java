package com.sys.billing.services;

import com.sys.billing.models.Bill;
import com.sys.billing.repositories.BillingRepository;
import com.sys.billing.repositories.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class BillingService {

    private BillingRepository billingRepository;
    private CartRepository cartRepository;
    @Autowired
    BillingService(BillingRepository billingRepository, CartRepository cartRepository){
        this.billingRepository = billingRepository;
        this.cartRepository = cartRepository;
    }

    public Bill saveBill(Bill bill) {
        bill.getCartItems().forEach(item -> cartRepository.save(item));
        return billingRepository.save(bill);
    }

    public Bill getBill(UUID id) {
        return null;
    }
}

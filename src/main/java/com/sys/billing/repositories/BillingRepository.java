package com.sys.billing.repositories;

import com.sys.billing.models.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillingRepository extends JpaRepository<Bill, Integer> {
}
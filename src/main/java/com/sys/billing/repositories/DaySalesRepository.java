package com.sys.billing.repositories;

import com.sys.billing.models.DaySales;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface DaySalesRepository extends JpaRepository<DaySales, LocalDate> {
    DaySales findDaySalesByDate(LocalDate date);
}

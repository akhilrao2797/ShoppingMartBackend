package com.sys.billing.models;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@Getter
public class DaySales {

    @Id
    private LocalDate date;
    private float MRP;
    private float totalSoldPrice;
    private float tax;
}

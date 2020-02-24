package com.sys.billing.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class DaySales {

    @Id
    private Date date;
    private float MRP;
    private float totalSoldPrice;
    private float tax;
}

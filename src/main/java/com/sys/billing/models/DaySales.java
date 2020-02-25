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

    public Date getDate() {
        return date;
    }

    public float getMRP() {
        return MRP;
    }

    public float getTotalSoldPrice() {
        return totalSoldPrice;
    }

    public float getTax() {
        return tax;
    }

    public DaySales setDate(Date date) {
        this.date = date;
        return this;
    }

    public DaySales setMRP(float MRP) {
        this.MRP = MRP;
        return this;
    }

    public DaySales setTotalSoldPrice(float totalSoldPrice) {
        this.totalSoldPrice = totalSoldPrice;
        return this;
    }

    public DaySales setTax(float tax) {
        this.tax = tax;
        return this;
    }
}

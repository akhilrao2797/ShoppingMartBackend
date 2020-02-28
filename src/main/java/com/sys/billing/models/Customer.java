package com.sys.billing.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.UUID;

@Entity
public class Customer implements Serializable {
    @Id
    @GeneratedValue(generator="uuid")
    @GenericGenerator(name="uuid",strategy = "uuid2")
    private UUID customerId;

    @NotEmpty
    @Size(max = 26)
    private String customerName;

    @Size(min = 10, message = "Customer phone no. should contain 10 digits only", max = 10)
    private String customerPhone;

    @Size(min = 8)
    private String customerAddress;

    @Email(message = "email should be valid")
    private String customerEmail;

    @JsonIgnore
    private int discount;

    @JsonIgnore
    private String coupons;

    public UUID getCustomerId() {
        return customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public int getDiscount() {
        return discount;
    }

    public String getCoupons() {
        return coupons;
    }

    public Customer setCustomerId(UUID customerId) {
        this.customerId = customerId;
        return this;
    }

    public Customer setCustomerName(String customerName) {
        this.customerName = customerName;
        return this;
    }

    public Customer setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
        return this;
    }

    public Customer setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
        return this;
    }

    public Customer setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
        return this;
    }

    public Customer setDiscount(int discount) {
        this.discount = discount;
        return this;
    }

    public Customer setCoupons(String coupons) {
        this.coupons = coupons;
        return this;
    }
}

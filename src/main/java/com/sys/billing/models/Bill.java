package com.sys.billing.models;

import com.sys.billing.utils.Payment_Mode;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
public class Bill implements Serializable {

    @Id
    @GeneratedValue(generator="uuid")
    @GenericGenerator(name="uuid",strategy = "uuid2")
    private UUID billId;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE, orphanRemoval = true)
    private List<Cart> cartItems = new ArrayList<>();

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer", referencedColumnName = "customerName")
    private Customer customer;

    @NotNull
    private float totalPrice;

    private Payment_Mode paymentMode;
    
    private LocalDateTime dateTime;


    public UUID getBillId() {
        return billId;
    }

    public List<Cart> getCartItems() {
        return cartItems;
    }

    public Customer getCustomer() {
        return customer;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public Payment_Mode getPaymentMode() {
        return paymentMode;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public Bill setBillId(UUID billId) {
        this.billId = billId;
        return this;
    }

    public Bill setCartItems(List<Cart> cartItems) {
        this.cartItems = cartItems;
        return this;
    }

    public Bill setCustomer(Customer customer) {
        this.customer = customer;
        return this;
    }

    public Bill setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
        return this;
    }

    public Bill setPaymentMode(Payment_Mode paymentMode) {
        this.paymentMode = paymentMode;
        return this;
    }

    public Bill setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
        return this;
    }
}

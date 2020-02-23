package com.sys.billing.models;

import javax.persistence.*;

@Entity
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private Item item;
    private float itemFinalPrice;
    private float itemQuantity;
}

package com.sys.billing.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(referencedColumnName = "itemName", name = "item")
    private Item item;

    @NotNull
    private float itemFinalPrice;

    @NotNull
    private float itemQuantity;

    public long getId() {
        return id;
    }

    public Item getItem() {
        return item;
    }

    public float getItemFinalPrice() {
        return itemFinalPrice;
    }

    public float getItemQuantity() {
        return itemQuantity;
    }

    public Cart setId(long id) {
        this.id = id;
        return this;
    }

    public Cart setItem(Item item) {
        this.item = item;
        return this;
    }

    public Cart setItemFinalPrice(float itemFinalPrice) {
        this.itemFinalPrice = itemFinalPrice;
        return this;
    }

    public Cart setItemQuantity(float itemQuantity) {
        this.itemQuantity = itemQuantity;
        return this;
    }
}

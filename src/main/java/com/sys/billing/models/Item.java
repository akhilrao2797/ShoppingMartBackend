package com.sys.billing.models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.UUID;

@Entity
public class Item implements Serializable {

    @Id
    @GeneratedValue(generator="uuid")
    @GenericGenerator(name="uuid",strategy = "uuid2")
    private UUID itemId;

    private short itemWeight;

    @NotEmpty(message = "item name is mandatory")
    private String itemName;

    @NotEmpty(message = "item MRP is mandatory")
    private float itemMRP;

    @NotEmpty(message = "item price is mandatory")
    private float itemPrice;

    @NotNull
    private String itemManufacturer;

    @OneToOne(cascade = CascadeType.ALL)
    private Inventory inventory;

    public UUID getItemId() {
        return itemId;
    }

    public short getItemWeight() {
        return itemWeight;
    }

    public String getItemName() {
        return itemName;
    }

    public float getItemMRP() {
        return itemMRP;
    }

    public float getItemPrice() {
        return itemPrice;
    }

    public String getItemManufacturer() {
        return itemManufacturer;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public Item setItemId(UUID itemId) {
        this.itemId = itemId;
        return this;
    }

    public Item setItemWeight(short itemWeight) {
        this.itemWeight = itemWeight;
        return this;
    }

    public Item setItemName(String itemName) {
        this.itemName = itemName;
        return this;
    }

    public Item setItemMRP(float itemMRP) {
        this.itemMRP = itemMRP;
        return this;
    }

    public Item setItemPrice(float itemPrice) {
        this.itemPrice = itemPrice;
        return this;
    }

    public Item setItemManufacturer(String itemManufacturer) {
        this.itemManufacturer = itemManufacturer;
        return this;
    }

    public Item setInventory(Inventory inventory) {
        this.inventory = inventory;
        return this;
    }
}


package com.sys.billing.models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.UUID;

@Entity
public class Inventory implements Serializable {

    @Id
    @GeneratedValue(generator="uuid")
    @GenericGenerator(name="uuid",strategy = "uuid2")
    private UUID inventoryId;

    @NotNull
    private short totalQuantity;

    @NotNull
    private short thresholdQuantity;



    public UUID getInventoryId() {
        return inventoryId;
    }

    public short getTotalQuantity() {
        return totalQuantity;
    }

    public short getThresholdQuantity() {
        return thresholdQuantity;
    }

    public Inventory setInventoryId(UUID inventoryId) {
        this.inventoryId = inventoryId;
        return this;
    }

    public Inventory setTotalQuantity(short totalQuantity) {
        this.totalQuantity = totalQuantity;
        return this;
    }

    public Inventory setThresholdQuantity(short thresholdQuantity) {
        this.thresholdQuantity = thresholdQuantity;
        return this;
    }
}

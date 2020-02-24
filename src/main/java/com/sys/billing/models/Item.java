package com.sys.billing.models;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Getter
@Setter
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
}


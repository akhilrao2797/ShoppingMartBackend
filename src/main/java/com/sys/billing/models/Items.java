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
@IdClass(Items.ItemKey.class)
public class Items implements Serializable {

    @Id
    @GeneratedValue(generator="uuid")
    @GenericGenerator(name="uuid",strategy = "uuid2")
    private UUID itemId;

    @Id
    private short itemWeight;

    @NotEmpty(message = "item name is mandatory")
    private String itemName;

    @NotEmpty(message = "item price is mandatory")
    private float itemPrice;

    @NotNull
    private String itemManufacturer;

    class ItemKey implements Serializable{
        UUID itemId;
        short itemWeight;
    }

}

//@OneToOne(mappedBy = "item", cascade = CascadeType.ALL)
//    private Inventory inventory;

package com.sys.billing.models;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Getter
@Setter
public class Inventory implements Serializable {

    @Id
    @GeneratedValue(generator="uuid")
    @GenericGenerator(name="uuid",strategy = "uuid2")
    private UUID inventoryId;

    private short totalQuantity;

    private short thresholdQuantity;
}

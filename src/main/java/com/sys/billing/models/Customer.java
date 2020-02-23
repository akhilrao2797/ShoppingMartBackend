package com.sys.billing.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Getter
@Setter
public class Customer implements Serializable {
    @Id
    @GeneratedValue(generator="uuid")
    @GenericGenerator(name="uuid",strategy = "uuid2")
    private UUID customerId;

    @NotNull
    @Size(max = 26)
    private String customerName;

    @Size(min = 10, message = "Customer phone no. should contain 10 digits only", max = 10)
    private String customerPhone;

    @Size(min = 8)
    private String customerAddress;

    @JsonIgnore
    private int discount;

    @JsonIgnore
    private String coupons;
}

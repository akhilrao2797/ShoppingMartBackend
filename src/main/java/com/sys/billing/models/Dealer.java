package com.sys.billing.models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
public class Dealer {

    @Id
    @GeneratedValue(generator="uuid")
    @GenericGenerator(name="uuid",strategy = "uuid2")
    private UUID dealerId;

    private String dealerName;
    private String dealerPhone;
    @Email(message = "email should be valid")
    private String dealerEmail;
    @OneToOne
    private Item item;
    private float balanceAmount;
    private LocalDateTime lastStockRefreshDate;
    private LocalDateTime recentStockRefreshDate;
}

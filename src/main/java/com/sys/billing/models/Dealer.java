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

    public UUID getDealerId() {
        return dealerId;
    }

    public String getDealerName() {
        return dealerName;
    }

    public String getDealerPhone() {
        return dealerPhone;
    }

    public String getDealerEmail() {
        return dealerEmail;
    }

    public Item getItem() {
        return item;
    }

    public float getBalanceAmount() {
        return balanceAmount;
    }

    public LocalDateTime getLastStockRefreshDate() {
        return lastStockRefreshDate;
    }

    public LocalDateTime getRecentStockRefreshDate() {
        return recentStockRefreshDate;
    }

    public void setDealerId(UUID dealerId) {
        this.dealerId = dealerId;
    }

    public void setDealerName(String dealerName) {
        this.dealerName = dealerName;
    }

    public void setDealerPhone(String dealerPhone) {
        this.dealerPhone = dealerPhone;
    }

    public void setDealerEmail(String dealerEmail) {
        this.dealerEmail = dealerEmail;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public void setBalanceAmount(float balanceAmount) {
        this.balanceAmount = balanceAmount;
    }

    public void setLastStockRefreshDate(LocalDateTime lastStockRefreshDate) {
        this.lastStockRefreshDate = lastStockRefreshDate;
    }

    public void setRecentStockRefreshDate(LocalDateTime recentStockRefreshDate) {
        this.recentStockRefreshDate = recentStockRefreshDate;
    }
}

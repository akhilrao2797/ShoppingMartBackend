package com.sys.billing.models;

import com.sys.billing.utils.Payment_Mode;

import java.util.List;

public class Bill {
    private int billId;
    private List<Items> items;
    private List<Integer> quantities;
    private List<Integer> price;
    private int totalPrice;
    private Payment_Mode paymentMode;
}

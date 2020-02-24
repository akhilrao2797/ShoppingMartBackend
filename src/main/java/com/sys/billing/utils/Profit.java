package com.sys.billing.utils;

import lombok.Setter;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@Setter
public class Profit {

    private float totalProfit;
    private Map<LocalDate, Float> dayVsProfit;

    private Profit(){
        totalProfit = 0;
        dayVsProfit = new HashMap<>();
    }

    public static Profit ProfitBuilder(){
        return new Profit();
    }

    public Profit setTotalProfit(float profit){
        this.totalProfit = profit;
        return this;
    }

    public float getTotalProfit(){
        return this.totalProfit;
    }

    public Profit addDayProfitPair(LocalDate date, float profit){
        this.dayVsProfit.putIfAbsent(date, profit);
        return this;
    }
}

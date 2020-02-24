package com.sys.billing.services;

import com.sys.billing.models.DaySales;
import com.sys.billing.models.Item;
import com.sys.billing.repositories.DaySalesRepository;
import com.sys.billing.utils.Profit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import java.sql.Date;
//import java.time.LocalDate;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProfitService {

    private ItemService itemService;
    private DaySalesRepository daySalesRepository;
    private BillingService billingService;

    @Autowired
    ProfitService(ItemService itemService, DaySalesRepository daySalesRepository, BillingService billingService){
        this.itemService = itemService;
        this.daySalesRepository = daySalesRepository;
        this.billingService = billingService;
    }

    public float getDailyProfit(LocalDate date){
        DaySales daySales = daySalesRepository.findDaySalesByDate(date);
        return daySales.getMRP() - daySales.getTotalSoldPrice();
    }

    public Profit getProfitForSpecifiedDate(LocalDate fromDate, LocalDate toDate){
        List<DaySales> daySalesList = new ArrayList<>();
        Profit profit = Profit.ProfitBuilder();

        while(fromDate.isBefore(toDate)){
            daySalesList.add(daySalesRepository.findDaySalesByDate(fromDate));
            float dayProfit = getDailyProfit(fromDate);
            profit.addDayProfitPair(fromDate, dayProfit);
            profit.setTotalProfit(profit.getTotalProfit() + dayProfit);
            fromDate = fromDate.plusDays(1);
        }
    }

    public float getProfitOnParticularItem(Item item, LocalDate fromDate, LocalDate toDate){
    }
}

package com.example.geektrust.bean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Summary {

    private HashMap<String,Passenger> passengerMap;
    private List<CheckIn> checkIns;
    private Integer revenue_Airport;
    private Integer revenue_Central;
    private Integer discount_Airport;
    private Integer discount_Central;
    private List<String> order_Airport;
    private List<String> order_Central;
    public Summary() {
        this.passengerMap=new HashMap<>();
        this.checkIns =new ArrayList<>();
        this.revenue_Airport =0;
        this.revenue_Central =0;
        this.discount_Airport =0;
        this.discount_Central =0;
        this.order_Airport =new ArrayList<>();
        this.order_Central =new ArrayList<>();
    }
    public List<String> getOrder_Airport() {
        return order_Airport;
    }

    public List<String> getOrder_Central() {
        return order_Central;
    }

    public Integer getRevenue_Airport() {
        return revenue_Airport;
    }

    public void setRevenue_Airport(Integer revenue_Airport) {
        this.revenue_Airport = revenue_Airport;
    }

    public Integer getRevenue_Central() {
        return revenue_Central;
    }

    public void setRevenue_Central(Integer revenue_Central) {
        this.revenue_Central = revenue_Central;
    }

    public Integer getDiscount_Airport() {
        return discount_Airport;
    }

    public void setDiscount_Airport(Integer discount_Airport) {
        this.discount_Airport = discount_Airport;
    }

    public Integer getDiscount_Central() {
        return discount_Central;
    }

    public void setDiscount_Central(Integer discount_Central) {
        this.discount_Central = discount_Central;
    }

    public HashMap<String, Passenger> getPassengerMap() {
        return passengerMap;
    }
    public List<CheckIn> getCheckIns() {
        return checkIns;
    }
}


package com.example.geektrust.bean;

public class Charge_Journey {
    private Integer discount;
    private Integer cost_Journey;
    public Charge_Journey(Integer discount, Integer cost_Journey) {
        this.discount = discount;
        this.cost_Journey = cost_Journey;
    }
    public Integer getDiscount() {
        return discount;
    }
    public Integer getCost_Journey() {
        return cost_Journey;
    }


}

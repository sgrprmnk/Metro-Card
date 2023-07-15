package com.example.geektrust.bean;

public class Statistics {


    private Integer count;
    private String passenger;
    private Integer charges;
    private Integer discounts;
    private Integer order;
    public Statistics(String passenger) {
        this.passenger = passenger;
        this.charges =0;
        this.discounts =0;
        this.count=0;
    }

    public Statistics(String passenger, Integer count, Integer charges, Integer discounts) {
        this.count = count;
        this.passenger = passenger;
        this.charges = charges;
        this.discounts = discounts;

    }

    public void setOrder(Integer order) {
        this.order = order;
    }
    public Integer getCount() {
        return count;
    }
    public void setCount(Integer count) {
        this.count = count;
    }
    public String getPassenger() {
        return passenger;
    }

    public Integer getCharges() {
        return charges;
    }
    public void setCharges(Integer charges) {
        this.charges = charges;
    }
    public Integer getDiscounts() {
        return discounts;
    }
    public void setDiscounts(Integer discounts) {
        this.discounts = discounts;
    }

    @Override
    public boolean equals(Object obj) {
        if(this==obj) {
            return true;
        }
        if(obj==null || this.getClass()!=obj.getClass()) {
            return false;
        }
        Statistics stats=(Statistics)obj;;
        return this.count.equals(stats.count)
                && this.passenger.equals(stats.passenger)
                && this.charges.equals(stats.charges)
                && this.discounts.equals(stats.discounts);
    }
}

package com.example.geektrust.bean;

public class Passenger {
    private String card;
    private Integer balance;
    private Integer travel;
    public Passenger(String card, Integer balance) {
        this.card = card;
        this.balance = balance;
        this.travel =0;
    }
    public Integer getTravel() {
        return travel;
    }
    public void setTravel(Integer travel) {
        this.travel = travel;
    }
    public Integer getBalance() {
        return balance;
    }
    public void setBalance(Integer balance) {
        this.balance = balance;
    }
}

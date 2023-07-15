package com.example.geektrust.bean;

import com.example.geektrust.charges.Fixed;

public class CheckIn {

    private String card;
    private String passenger;
    private String departure;
    private Integer charge;
    private Charge_Journey charges_Journey;

    public CheckIn(String card, String passenger, String departure) {
        this.card = card;
        this.passenger = passenger;
        this.departure = departure;
        setCharge(this.passenger);
    }
    public Charge_Journey getJourneyCharge() {
        return charges_Journey;
    }

    public void setJourneyCharge(Charge_Journey journeyChargeJourney) {
        this.charges_Journey = journeyChargeJourney;
    }

    public Integer getCharge() {
        return charge;
    }

public void setCharge(String passengerType) {
    switch (passengerType) {
        case "ADULT":
            this.charge = Fixed.ADULT;
            break;
        case "SENIOR_CITIZEN":
            this.charge = Fixed.SENIOR_CITIZEN;
            break;
        case "KID":
            this.charge = Fixed.KIDS;
            break;
        default:
            // handle invalid input
            break;
    }
}
    public String getPassenger() {
        return passenger;
    }

    public String getDeparture() {
        return departure;
    }

    public String getCard() {
        return card;
    }

    @Override
    public boolean equals(Object obj) {
        if(this==obj) {
            return true;
        }
        if(obj==null || this.getClass()!=obj.getClass()) {
            return false;
        }
        CheckIn checkedIn=(CheckIn)obj;;
        return this.passenger.equals(checkedIn.passenger)
                && this.departure.equals(checkedIn.departure)
                && this.card.equals(checkedIn.card)
                && this.charge.equals(checkedIn.charge);
    }

}

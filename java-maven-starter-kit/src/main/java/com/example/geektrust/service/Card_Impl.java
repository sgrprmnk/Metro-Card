package com.example.geektrust.service;

import com.example.geektrust.exception.Card_Exception;
import com.example.geektrust.bean.*;
import com.example.geektrust.utility.Check_Impl;

import java.util.*;
import java.util.stream.Collectors;

public class Card_Impl implements Metro_Card {

    private Summary summary=new Summary();

    @Override
    public String executeCommands(List<Commands> arguments) {

        StringBuilder output = new StringBuilder();
        Check_Impl inputCheck = new Check_Impl();

        for (Commands input : arguments) {
            inputCheck.validateCommand(input);

            switch (input.getCommand()) {
                case "BALANCE":
                    initBalance(input.getToken());
                    break;
                case "CHECK_IN":
                    checkInStation(input.getToken());
                    break;
                case "PRINT_SUMMARY":
                    output.append(printSummary());
                    System.out.println(output);
                    break;
                default:
                    throw new Card_Exception("Invalid Input Commands, please check the input command.");
            }
        }

        return output.toString();
    }

    @Override
    public Passenger initBalance(List<String> tokens) {
        String id = tokens.get(0);
        int balance = Integer.parseInt(tokens.get(1));
        Passenger passenger = new Passenger(id, balance);
        summary.getPassengerMap().put(id, passenger);
        return passenger;
    }
    @Override
    public void checkInStation(List<String> tokens) {
        CheckIn checkedIn = checkListInit(tokens);
        Charge_Journey journeyChargeJourney = updateBalance(checkedIn.getCard(), checkedIn.getCharge());
        checkedIn.setJourneyCharge(journeyChargeJourney);

        String departure = checkedIn.getDeparture();
        String passenger = checkedIn.getPassenger();

        if (departure.equals("AIRPORT") && !summary.getOrder_Airport().contains(passenger)) {
            summary.getOrder_Airport().add(passenger);
        }
        if (departure.equals("CENTRAL") && !summary.getOrder_Central().contains(passenger)) {
            summary.getOrder_Central().add(passenger);
        }
        summary.getCheckIns().add(checkedIn);
    }

    @Override
    public String printSummary() {
        return stationStatistics(summary.getCheckIns());
    }


    public String stationStatistics(List<CheckIn> checkedIn) {
        StringBuilder output = new StringBuilder();

        Map<String, List<CheckIn>> passengerAtAirport = checkedIn.stream()
                .filter(current -> current.getDeparture().equals("AIRPORT"))
                .collect(Collectors.groupingBy(CheckIn::getPassenger));
        List<Statistics> airportStats = stationPerStatistic("AIRPORT", passengerAtAirport);
        String airportSummary = summaryCreator("AIRPORT", airportStats);

        Map<String, List<CheckIn>> passengerAtCentral = checkedIn.stream()
                .filter(current -> current.getDeparture().equals("CENTRAL"))
                .collect(Collectors.groupingBy(CheckIn::getPassenger));
        List<Statistics> centralStats = stationPerStatistic("CENTRAL", passengerAtCentral);
        String centralSummary = summaryCreator("CENTRAL", centralStats);

        output.append("TOTAL_COLLECTION CENTRAL ")
                .append(summary.getRevenue_Central())
                .append(" ")
                .append(summary.getDiscount_Central())
                .append("\n");
        output.append("PASSENGER_TYPE_SUMMARY\n")
                .append(centralSummary);
        output.append("TOTAL_COLLECTION AIRPORT ")
                .append(summary.getRevenue_Airport())
                .append(" ")
                .append(summary.getDiscount_Airport())
                .append("\n");
        output.append("PASSENGER_TYPE_SUMMARY\n")
                .append(airportSummary);

        return output.toString();
    }


    public String summaryCreator(String station, List<Statistics> stationStats) {
        StringBuilder output = new StringBuilder();
        int totalCharge = 0;
        int totalDiscount = 0;

        for (Statistics stats : stationStats) {
            totalCharge += stats.getCharges();
            totalDiscount += stats.getDiscounts();
            output.append(stats.getPassenger()).append(" ").append(stats.getCount()).append("\n");
        }

        if (station.equals("AIRPORT")) {
            summary.setRevenue_Airport(totalCharge);
            summary.setDiscount_Airport(totalDiscount);
        } else if (station.equals("CENTRAL")) {
            summary.setRevenue_Central(totalCharge);
            summary.setDiscount_Central(totalDiscount);
        }

        return output.toString();
    }

    public List<Statistics> stationPerStatistic(String fromStation, Map<String,List<CheckIn>> passengerAtStation) {
        List<Statistics> stationStatsList=new ArrayList<>();

        for(Map.Entry<String, List<CheckIn>> current: passengerAtStation.entrySet()) {
            Statistics statistics=new Statistics(current.getKey());
            if(fromStation.equals("AIRPORT")) {
                statistics.setOrder(summary.getOrder_Airport().indexOf(current.getKey()));
            }
            if(fromStation.equals("CENTRAL")) {
                statistics.setOrder(summary.getOrder_Central().indexOf(current.getKey()));
            }
            for(CheckIn passenger: current.getValue()) {
                statistics.setCount(statistics.getCount()+1);
                statistics.setCharges(statistics.getCharges()+passenger.getJourneyCharge().getCost_Journey());
                statistics.setDiscounts(statistics.getDiscounts()+passenger.getJourneyCharge().getDiscount());
            }
            stationStatsList.add(statistics);
        }
        stationStatsList= orderAmount(stationStatsList);
        return stationStatsList;
    }

    public List<Statistics> orderAmount(List<Statistics> stationStatsList) {
        stationStatsList.sort(
                Comparator.comparing(Statistics::getPassenger).reversed()
                        .thenComparing(Statistics::getCharges).reversed()
                        .thenComparing(Comparator.comparing(Statistics::getCount).reversed())
                        .thenComparing(Statistics::getDiscounts)

        );
        return stationStatsList;
    }



    public CheckIn checkListInit(List<String> tokens) {
        return new CheckIn(tokens.get(0),tokens.get(1),tokens.get(2));
    }

    public Charge_Journey updateBalance(String id, int charge) {
        int totalAmountCollected = 0;
        int discount=0;
        Passenger currentPassenger = summary.getPassengerMap().get(id);
        if(currentPassenger==null) {
            throw new Card_Exception("MetroCard User Not Registered");
        }
        currentPassenger.setTravel(currentPassenger.getTravel() + 1);

        if (currentPassenger.getTravel() % 2 == 0) {
            charge = charge / 2;
            discount=charge;
        }

        if (currentPassenger.getBalance() < charge) {
            int balanceRequired = charge - currentPassenger.getBalance();
            totalAmountCollected += 0.02 * balanceRequired;
            currentPassenger.setBalance(0);
        } else {
            currentPassenger.setBalance(currentPassenger.getBalance() - charge);
        }
        totalAmountCollected += charge;
        return new Charge_Journey(discount,totalAmountCollected);
    }
}
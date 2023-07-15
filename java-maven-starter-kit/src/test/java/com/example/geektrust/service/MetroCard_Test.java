package com.example.geektrust.service;

import com.example.geektrust.bean.Charge_Journey;
import com.example.geektrust.bean.CheckIn;
import com.example.geektrust.bean.Statistics;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MetroCard_Test {
    Card_Impl service;

    @BeforeEach
    void setUp() {
        service=new Card_Impl();
    }

    @Test
    public void testSeniorCitizenTravelFromAirport() {
        List<String> tokens=new ArrayList<>();
        tokens.add("MC1");
        tokens.add("SENIOR_CITIZEN");
        tokens.add("AIRPORT");
        CheckIn charge = service.checkListInit(tokens);
        assertEquals(100, charge.getCharge());
    }
    @Test
    public void stationPerStatisticTest() {
        Map<String,List<CheckIn>> passengerAtStation=new HashMap<>();
        //Input Initialization
        List<CheckIn> seniorCitizenList=new ArrayList<>();
        CheckIn seniorCitizen1=new CheckIn("MC1", "SENIOR_CITIZEN", "CENTRAL");
        seniorCitizen1.setJourneyCharge(new Charge_Journey(0, 100));
        seniorCitizenList.add(seniorCitizen1);
        passengerAtStation.put("SENIOR_CITIZEN", seniorCitizenList);

        List<CheckIn> adultList=new ArrayList<>();
        CheckIn adultCitizen1=new CheckIn("MC3", "ADULT", "CENTRAL");
        adultCitizen1.setJourneyCharge(new Charge_Journey(0, 200));
        adultList.add(adultCitizen1);
        CheckIn adultCitizen2=new CheckIn("MC3", "ADULT", "CENTRAL");
        adultCitizen2.setJourneyCharge(new Charge_Journey(100, 100));
        adultList.add(adultCitizen2);
        passengerAtStation.put("ADULT", adultList);
        List<Statistics> stationStatsList=new ArrayList<>();
        stationStatsList.add(new Statistics("ADULT",2,300,100));
        stationStatsList.add(new Statistics("SENIOR_CITIZEN",1,100,0));
        List<Statistics> output=service.stationPerStatistic("AIRPORT",passengerAtStation);
        assertEquals(output, stationStatsList);
    }

    @Test
    public void summaryCreatorTest() {
        String station="AIRPORT";

        List<Statistics> stationStatsList=new ArrayList<>();
        stationStatsList.add(new Statistics("ADULT",2,300,100));
        stationStatsList.add(new Statistics("SENIOR_CITIZEN",1,100,0));

        String expectedOutput="ADULT 2\nSENIOR_CITIZEN 1\n";

        String actualOutput=service.summaryCreator(station, stationStatsList);
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void passengerCheckInsTest() {
        List<String> tokens=new ArrayList<>();
        tokens.add("MC1");
        tokens.add("SENIOR_CITIZEN");
        tokens.add("AIRPORT");
        CheckIn checkedInExpected=new CheckIn("MC1", "SENIOR_CITIZEN", "AIRPORT");
        checkedInExpected.setCharge("SENIOR_CITIZEN");
        assertEquals(checkedInExpected, service.checkListInit(tokens));
    }
}

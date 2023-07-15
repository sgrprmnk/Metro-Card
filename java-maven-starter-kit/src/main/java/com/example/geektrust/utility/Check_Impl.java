package com.example.geektrust.utility;

import com.example.geektrust.exception.Card_Exception;
import com.example.geektrust.bean.Commands;

import java.util.List;

public class Check_Impl implements Check {

    @Override
    public void validateCommand(Commands inputCommand) {
        String command = inputCommand.getCommand();
        switch (command) {
            case "BALANCE":
                balanceCheckByCommand(inputCommand.getToken());
                break;
            case "CHECK_IN":
                commandCheckIns(inputCommand.getToken());
                break;
            case "PRINT_SUMMARY":
                printSummaryCheck(inputCommand.getToken());
                break;
            default:
                throw new Card_Exception("Invalid Input Commands, please check the input command.");
        }
    }

    public void balanceCheckByCommand(List<String> tokens) {
        if(tokens.size()!=2) {
            throw new Card_Exception("Invalid Number of Arguments, Please validate input.");
        }
     int balance = Integer.parseInt(tokens.get(1));
        if(balance<0) {
            throw new Card_Exception("MetroCard Balance should be non negative, Please validate input.");
        }


    }
    public void commandCheckIns(List<String> tokens) {
        if(tokens.size()!=3) {
            throw new Card_Exception("Invalid Number of Arguments, Please validate input.");
        }
        String passengerType=tokens.get(1);
        if(!passengerType.equals("ADULT") && !passengerType.equals("SENIOR_CITIZEN") && !passengerType.equals("KID")) {
            throw new Card_Exception("Invalid Passenger Type, Please validate input.");
        }
        String fromStation=tokens.get(2);
        if(!fromStation.equals("AIRPORT") && !fromStation.equals("CENTRAL")) {
            throw new Card_Exception("Invalid Station, MetroCard Available Stations are : 1)AIRPORT  2)CENTRAL.");
        }
    }



    public void printSummaryCheck(List<String> tokens) {
        if(tokens.size()!=0)
            throw new Card_Exception("Invalid Number of Arguments, Please validate input.");
    }

}
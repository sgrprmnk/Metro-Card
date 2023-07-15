package com.example.geektrust.service;

import com.example.geektrust.bean.Commands;
import com.example.geektrust.bean.Passenger;

import java.util.List;

public interface Metro_Card {
   String executeCommands(List<Commands> arguments);

 Passenger initBalance(List<String> tokens);

  void checkInStation(List<String> tokens);

String printSummary();
}

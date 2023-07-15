package com.example.geektrust;

import com.example.geektrust.exception.Card_Exception;
import com.example.geektrust.bean.Commands;
import com.example.geektrust.service.Metro_Card;
import com.example.geektrust.service.Card_Impl;
import com.example.geektrust.utility.Process;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
            try {
                if (args.length != 1) {
                    throw new Card_Exception("Input file not supplied. Please provide the input file");
                }
                String filePath = args[0];
                processMetroCard(filePath);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        public static String processMetroCard(String filePath) throws IOException {
            Process reader = new Process(filePath);
            List<Commands> commands = reader.commandFile();
            Metro_Card cardService=new Card_Impl();
            return cardService.executeCommands(commands);
        }
    }

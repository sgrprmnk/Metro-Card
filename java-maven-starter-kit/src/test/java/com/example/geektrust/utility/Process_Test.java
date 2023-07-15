package com.example.geektrust.utility;

import com.example.geektrust.bean.Commands;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Process_Test {
    private Process file;

    @BeforeEach
    void setUp() {
        file =new Process();
    }

    @Test
    public void parseInputTest() {
        List<String> tokens=new ArrayList<>();
        tokens.add("MC1");
        Integer balance=100;
        tokens.add(balance.toString());
        Commands expectedCommand=new Commands("BALANCE", tokens);
        Commands actualCommand= file.parseInput("BALANCE MC1 100");
        assertEquals(actualCommand, expectedCommand);
    }
}

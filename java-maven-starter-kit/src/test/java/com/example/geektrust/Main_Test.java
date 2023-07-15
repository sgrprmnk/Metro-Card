package com.example.geektrust;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Main_Test {
    private Main cardService;
    @BeforeEach
    void setUp() {
     cardService =new Main();
    }
    @Test
    public void input1() throws IOException {
        String filePath="src/test/java/resources/Test_1";
        String actualOutput= cardService.processMetroCard(filePath);

        String expectedOutput="TOTAL_COLLECTION CENTRAL 300 0\n"
                + "PASSENGER_TYPE_SUMMARY\n"
                + "ADULT 1\n"
                + "SENIOR_CITIZEN 1\n"
                + "TOTAL_COLLECTION AIRPORT 403 100\n"
                + "PASSENGER_TYPE_SUMMARY\n"
                + "ADULT 2\n"
                + "KID 2";

        assertEquals(actualOutput.trim(), expectedOutput);
    }

    @Test
    public void input2() throws IOException {
        String filePath="src/test/java/resources/Test_2";
        String actualOutput= cardService.processMetroCard(filePath);

        String expectedOutput="TOTAL_COLLECTION CENTRAL 504 50\n"
                + "PASSENGER_TYPE_SUMMARY\n"
                + "ADULT 2\n"
                + "KID 1\n"
                + "SENIOR_CITIZEN 1\n"
                + "TOTAL_COLLECTION AIRPORT 151 100\n"
                + "PASSENGER_TYPE_SUMMARY\n"
                + "ADULT 1\n"
                + "KID 1";

        assertEquals(actualOutput.trim(), expectedOutput);
    }

    @Test
    public void input3() throws IOException {
        String filePath="src/test/java/resources/Test_3";
        String actualOutput= cardService.processMetroCard(filePath);

        String expectedOutput="TOTAL_COLLECTION CENTRAL 300 50\n"
                + "PASSENGER_TYPE_SUMMARY\n"
                + "ADULT 1\n"
                + "KID 1\n"
                + "SENIOR_CITIZEN 1\n"
                + "TOTAL_COLLECTION AIRPORT 225 125\n"
                + "PASSENGER_TYPE_SUMMARY\n"
                + "ADULT 1\n"
                + "KID 1\n"
                + "SENIOR_CITIZEN 1";


        assertEquals(actualOutput.trim(), expectedOutput);
    }

    @Test
    public void input4() throws IOException {
        String filePath="src/test/java/resources/Test_4";
        String actualOutput= cardService.processMetroCard(filePath);

        String expectedOutput="TOTAL_COLLECTION CENTRAL 457 50\n"
                + "PASSENGER_TYPE_SUMMARY\n"
                + "ADULT 2\n"
                + "SENIOR_CITIZEN 1\n"
                + "TOTAL_COLLECTION AIRPORT 252 100\n"
                + "PASSENGER_TYPE_SUMMARY\n"
                + "ADULT 1\n"
                + "KID 1\n"
                + "SENIOR_CITIZEN 1";
        assertEquals(actualOutput.trim(), expectedOutput);
    }
}

package com.example.geektrust.utility;

import com.example.geektrust.exception.Card_Exception;
import com.example.geektrust.bean.Commands;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Process {
    private String path;

    public Process() {}

    public Process(String path) {
        this.path = path;
    }
    public List<Commands> commandFile() throws Card_Exception {
        try (Stream<String> lines = Files.lines(Paths.get(this.path))) {
            return lines.filter(line -> !isEmptyOrComment(line))
                    .map(this::parseInput)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new Card_Exception("Some error occurred while processing input file");
        }
    }

    //Check if command is empty or is a comment
    private boolean isEmptyOrComment(String line) {
        return line.trim().isEmpty() || line.trim().startsWith("#");
    }
    public Commands parseInput(String str) {
        try {
            String[] commandWithArguments = str.split(" ");
            if (commandWithArguments.length < 1) {
                throw new UnsupportedOperationException("Empty command string");
            }
            List<String> tokens = Arrays.asList(Arrays.copyOfRange(commandWithArguments, 1, commandWithArguments.length));
            return  new Commands(commandWithArguments[0], tokens);
        } catch (Exception e) {
            throw new UnsupportedOperationException("Invalid Command Supplied: " + str);
        }

    }
}

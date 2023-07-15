package com.example.geektrust.bean;

import java.util.List;

public class Commands {
    private String command;
    private List<String> token;
    public Commands(String command, List<String> token) {
        this.command = command;
        this.token = token;
    }
    public String getCommand() {
        return command;
    }
    public List<String> getToken() {
        return token;
    }
    @Override
    public boolean equals(Object obj) {
        if(this==obj) {
            return true;
        }
        if(obj==null || this.getClass()!=obj.getClass()) {
            return false;
        }
        Commands inputCommand=(Commands)obj;;
        return this.command.equals(inputCommand.command)
                && this.token.equals(inputCommand.token);
    }
}

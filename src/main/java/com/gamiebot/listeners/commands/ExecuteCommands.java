package com.gamiebot.listeners.commands;

public class ExecuteCommands {

    private final Controller con;

    public ExecuteCommands(Controller con) {
        this.con = con;
    }

    public void help() {
        con.setReturnMessage("So " + con.getName() + " what can i help you white?");
    }
}

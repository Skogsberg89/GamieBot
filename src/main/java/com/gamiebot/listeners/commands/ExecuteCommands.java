package com.gamiebot.listeners.commands;

public class ExecuteCommands {

    private Controller con;

    public ExecuteCommands(Controller con) {
        this.con = con;
    }

    public void help() {
        con.setReturnMessage("need help " + con.getName());
    }
}

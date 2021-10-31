package com.gamiebot.listeners.commands;

import java.util.HashMap;
import java.util.Map;

public class Commands {
    public static final String ACTIVATE = ".gamie";
    public static final Map<String, Integer> commands;

    static {
        commands = new HashMap<>();
        commands.put(".gamie help", 1); //Print out all Commands
        commands.put(".gamie add me", 2); //Add lol player to db
        commands.put(".gamie show last game", 3); //Show last game player played
    }
}

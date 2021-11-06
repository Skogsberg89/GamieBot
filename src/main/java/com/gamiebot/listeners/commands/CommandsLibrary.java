package com.gamiebot.listeners.commands;

import java.util.HashMap;
import java.util.Map;

public abstract class CommandsLibrary {

    public Controller con;

    public final String LOL = ".gamie -lol";
    public final String STEAM = ".gamie -steam";

    public final Map<String, Runnable> lolCommands = new HashMap<>();{
        lolCommands.put(".gamie -lol add me", () -> System.out.println("LOL"));
    }
    public final Map<String, Runnable> otherCommands = new HashMap<>();{
        otherCommands.put(".gamie help", () -> new ExecuteCommands(con).help()); //Print out all Commands
    }
    public final Map<String, Runnable> steamCommands = new HashMap<>();{
        steamCommands.put(".gamie -steam news", () -> new ExecuteCommands(con).steamNews()); //Print out news for chosen game
    }
}

package com.gamiebot.listeners.commands;

import java.util.HashMap;
import java.util.Map;

public abstract class CommandsLibrary {

    protected Controller con;

    protected final String LOL = ".gamie -lol";
    protected final String STEAM = ".gamie -steam";

    protected final Map<String, Runnable> lolCommands = new HashMap<>();{
        lolCommands.put(".gamie -lol add me", () -> System.out.println("LOL"));
    }
    protected final Map<String, Runnable> otherCommands = new HashMap<>();{
        otherCommands.put(".gamie help", () -> new ExecuteCommands(con).help()); //Print out all Commands
    }
    protected final Map<String, Runnable> steamCommands = new HashMap<>();{
        steamCommands.put(".gamie -steam news", () -> new ExecuteCommands(con).steamNews()); //Print out news for chosen game
    }
}

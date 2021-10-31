package com.gamiebot.listeners.commands;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;

public class Commands {

    private Controller con;

    private final Map<String, Runnable> lolCommands = new HashMap<>();{
        lolCommands.put(".gamie -lol -add", () -> System.out.println("LOL")); //Add lol player to d
    }
    private final Map<String, Runnable> otherCommands = new HashMap<>();{
        otherCommands.put(".gamie -help", () -> new ExecuteCommands(con).help()); //Print out all Commands
    }

    public Commands(Controller con) {
        this.con = con;
        executeRightCommand(con.getMessage());
    }

    private Map<String, Runnable> checkCommand(String command) {
        String LOL = ".gamie -lol";
        if(command.startsWith(LOL)){
            return lolCommands;
        }else {
            return otherCommands;
        }
    }

    private void executeRightCommand(String command) {
        Map<String, Runnable> map = checkCommand(command);
        for (String c : map.keySet()) {
            if (command.startsWith(c)) {
                map.get(c).run();
                break;
            }else {
                commandDoesNotExist();
            }
        }
    }

    private void commandDoesNotExist() {
        String returnMessage = MessageFormat.format("Sorry {0}! \n " +
                "Don't know what you mean. \n " +
                "If you need help write <.gamie help>", con.getName());
        con.setReturnMessage(returnMessage);
    }
}

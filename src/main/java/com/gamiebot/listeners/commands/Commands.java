package com.gamiebot.listeners.commands;

import java.awt.*;
import java.text.MessageFormat;
import java.util.Map;

public class Commands extends CommandsLibrary{

    public Commands(Controller con) {
        this.con = con;
        executeRightCommand(con.getMessage());
    }

    private Map<String, Runnable> checkCommand(String command) {
        String LOL = ".gamie -lol";
        String STEAM = ".gamie -steam";
        if(command.startsWith(LOL)) { return lolCommands; }
        else if(command.startsWith(STEAM)) { return steamCommands; }
        else { return otherCommands; }
    }

    private void executeRightCommand(String command) {
        Map<String, Runnable> map = checkCommand(command);
        for (String c : map.keySet()) {
            System.out.println(c);
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
                "Do you need help? visit http://www.help.com", con.getName());
        con.setTitle("Failed!");
        con.setReturnMessage(returnMessage);
        con.setColor(Color.red);
        con.setIcon("https://icons.iconarchive.com/icons/paomedia/small-n-flat/48/sign-error-icon.png");
        con.setMessageBuilder(true);
    }
}

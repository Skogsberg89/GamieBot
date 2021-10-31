package com.gamiebot.listeners.commands;

import java.text.MessageFormat;
import java.util.Map;

public class Controller {

    private String message;
    private String name;
    private String returnMessage;
    private Map<String, Integer> commands;


    public Controller(String message, String name) {
        this.message = message;
        this.name = name;
        checkMessage(message);
    }

    private void checkMessage(String message) {
        commands = Commands.commands;
        for (String c : commands.keySet()) {
            System.out.println(c);
            if (message.startsWith(c)) {
                commandExecute(commands.get(c));
                break;
            }else {
                commandExecute(0);
            }
        }
    }

    private void commandExecute(int command) {
        switch (command){
            case 0:
                commandDoesNotExist();
        }
    }

    private void commandDoesNotExist() {
        String returnMessage = MessageFormat.format("Sorry {0}! \n " +
                "Don't know what you mean. \n " +
                "If you need help write <!Teemo help>", name);
        setReturnMessage(returnMessage);
    }

    public String getReturnMessage() {
        return returnMessage;
    }

    public void setReturnMessage(String returnMessage) {
        this.returnMessage = returnMessage;
    }
}

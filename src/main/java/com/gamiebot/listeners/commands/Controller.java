package com.gamiebot.listeners.commands;

public class Controller {

    private String message;
    private String name;
    private String returnMessage;

    public Controller(String message, String name) {
        this.message = message;
        this.name = name;
        checkMessage();
    }

    private void checkMessage() {
        new Commands(this);
    }

    public String getReturnMessage() {
        return returnMessage;
    }

    public void setReturnMessage(String returnMessage) {
        this.returnMessage = returnMessage;
    }

    public String getMessage() {
        return message;
    }

    public String getName() {
        return name;
    }
}

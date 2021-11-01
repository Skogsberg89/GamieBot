package com.gamiebot.listeners.commands;

import java.awt.*;

public class Controller {

    private final String message;
    private final String name;
    private String returnMessage;
    private String title;
    private String icon;
    private Color color;
    private boolean messageBuilder;

    public Controller(String message, String name) {
        this.message = message;
        this.name = name;
        messageBuilder = false;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public boolean isMessageBuilder() {
        return messageBuilder;
    }

    public void setMessageBuilder(boolean messageBuilder) {
        this.messageBuilder = messageBuilder;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}

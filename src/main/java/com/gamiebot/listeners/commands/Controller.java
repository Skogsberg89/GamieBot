package com.gamiebot.listeners.commands;

import java.awt.*;

public class Controller {

    private final String message;
    private final String name;
    private final String channel;
    private final String server;
    private String returnMessage;
    private String footer;
    private String title;
    private String icon;
    private String url;
    private Color color;
    private boolean messageBuilder;

    public Controller(String message, String name, String channel, String server) {
        this.message = message;
        this.name = name;
        this.channel = channel;
        this.server = server;
        this.messageBuilder = false;
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

    public String getChannel() {
        return channel;
    }

    public String getServer() {
        return server;
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

    public String getFooter() {
        return footer;
    }

    public void setFooter(String footer) {
        this.footer = footer;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}

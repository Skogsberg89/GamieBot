package com.gamiebot.listeners.impl;

import com.gamiebot.listeners.MessageListeners;
import com.gamiebot.listeners.commands.Controller;
import org.javacord.api.event.message.MessageCreateEvent;
import org.springframework.stereotype.Component;

@Component
public class Listener implements MessageListeners {

    private static final String ACTIVATE = ".gamie";
    private Controller con;

    @Override
    public void onMessageCreate(MessageCreateEvent event) {
        String name = event.getMessageAuthor().getDisplayName();
        String message = event.getMessageContent().toLowerCase();
        if(message.startsWith(ACTIVATE)){
            if(message.equals(ACTIVATE)){
                event.getChannel().sendMessage("Hi " + name + "!");
            }else {
                con = new Controller(message, name);
                event.getChannel().sendMessage(con.getReturnMessage());
            }
        }

    }
}

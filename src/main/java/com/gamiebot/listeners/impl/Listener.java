package com.gamiebot.listeners.impl;

import com.gamiebot.listeners.MessageListeners;
import com.gamiebot.listeners.commands.Commands;
import com.gamiebot.listeners.commands.Controller;
import org.javacord.api.event.message.MessageCreateEvent;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class Listener implements MessageListeners {

    private Controller con;

    @Override
    public void onMessageCreate(MessageCreateEvent event) {
        String name = event.getMessageAuthor().getDisplayName();
        String message = event.getMessageContent().toLowerCase();
        System.out.println(message);
        if(message.startsWith(Commands.ACTIVATE)){
            if(message.equals(Commands.ACTIVATE)){
                event.getChannel().sendMessage("Hi " + name + "!");
            }else {
                con = new Controller(message, name);
                event.getChannel().sendMessage(con.getReturnMessage());
            }
        }

    }
}

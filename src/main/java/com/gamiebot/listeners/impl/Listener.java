package com.gamiebot.listeners.impl;

import com.gamiebot.listeners.MessageListeners;
import com.gamiebot.listeners.commands.Controller;
import org.javacord.api.entity.message.MessageBuilder;
import org.javacord.api.entity.message.embed.EmbedBuilder;
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
                if(con.isMessageBuilder()){
                    messageBuilder(con, event);
                }else {
                    event.getChannel().sendMessage(con.getReturnMessage());
                }
            }
        }
    }

    private void messageBuilder(Controller con, MessageCreateEvent event) {
        new MessageBuilder().setEmbed(new EmbedBuilder()
                .setAuthor(event.getMessageAuthor())
                .setTitle(con.getTitle())
                .setDescription(con.getReturnMessage())
                .setThumbnail(con.getIcon())
                .setColor(con.getColor())).send(event.getChannel());
    }
}

package com.gamiebot.listeners.commands;

import com.gamiebot.steam.SteamNews;
import message.LogMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.MessageFormat;

public class ExecuteCommands {

    private static  final  Logger LOG = LoggerFactory.getLogger(ExecuteCommands.class);
    private final Controller con;
    private LogMessage logMessage;

    public ExecuteCommands(Controller con) {
        this.con = con;
        this.logMessage = new LogMessage();
    }

    public void help() {
        con.setReturnMessage("So " + con.getName() + " what can i help you with?");
    }

    public void steamNews() {
        String DELETE = ".gamie -steam news";
        String game = getArgumentFromCommand(con.getMessage(), DELETE);
        if(game.isEmpty()){
            LOG.info(logMessage.noGameLog(con));
            con.setReturnMessage(con.getName() + " Which game do you want news of?\n .game -steam news <game> ");
        }else {
            new SteamNews(game, con);
        }
    }

    private String getArgumentFromCommand(String command, String DELETE) {
        String app = command.replace(DELETE, "");
        return app.replace(" ", "");
    }
}


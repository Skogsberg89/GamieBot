package com.gamiebot.listeners.commands;

import com.gamiebot.steam.SteamNews;

public class ExecuteCommands {

    private final Controller con;

    public ExecuteCommands(Controller con) {
        this.con = con;
    }

    public void help() {
        con.setReturnMessage("So " + con.getName() + " what can i help you with?");
    }

    public void steamNews() {
        String DELETE = ".gamie -steam news";
        String game = getArgumentFromCommand(con.getMessage(), DELETE);
        if(game.isEmpty()){
            con.setReturnMessage(con.getName() + " Which game do you want news of?\n .game -steam new <game> ");
        }else {
            new SteamNews(game, con);
        }
    }

    private String getArgumentFromCommand(String command, String DELETE) {
        String app = command.replace(DELETE, "");
        return app.replace(" ", "");
    }
}


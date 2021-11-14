package message;

import com.gamiebot.listeners.commands.Controller;

import java.text.MessageFormat;

public class LogMessage {

    //Steam news when no game is given
    public String noGameLog(Controller con){
        return MessageFormat.format("No game was given by {0} in channel {1} in server {2}",
                con.getName(),
                con.getChannel(),
                con.getServer());
    }
}

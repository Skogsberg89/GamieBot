package message;

import com.gamiebot.listeners.commands.Controller;
import org.jetbrains.annotations.NotNull;

import java.text.MessageFormat;

public class LogMessage {

    //Steam news: When no game is given
    public static String noGameLog(@NotNull Controller con) {
        return MessageFormat.format("No game was given by {0} in channel {1} in server {2}",
                con.getName(),
                con.getChannel(),
                con.getServer());
    }

    //Steam news: Given game do not exist
    public static String cantFindGameLog(@NotNull Controller con, String game) {
        return MessageFormat.format("The game {0} do not exist in gamies library. User {1}, {2} in server {3}",
                game,
                con.getName(),
                con.getChannel(),
                con.getServer());
    }
}

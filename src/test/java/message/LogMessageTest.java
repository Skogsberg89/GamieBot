package message;

import com.gamiebot.listeners.commands.Controller;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LogMessageTest {

    public static Controller con;
    public String EXPECT_STRING;
    public String GAME;
    private final String TEST_USER = "testBot";
    private final String TEST_CHANNEL = "testChannel";
    private final String TEST_SERVER = "testServer";

    @Test
    @DisplayName("When No game is given, Steam news")
    void noGameLog() {
        //Given
        con = new Controller(".gamie -steam news", TEST_USER, TEST_CHANNEL, TEST_SERVER);
        EXPECT_STRING = "No game was given by testBot in channel testChannel in server testServer";
        //When
        String actualString = LogMessage.noGameLog(con);
        //Expect
        assertEquals(EXPECT_STRING, actualString);
    }

    @Test
    @DisplayName("When given game is not existing in bots library")
    void cantFindGameLog() {
        //Given
        GAME = "testGame";
        con = new Controller("a message", TEST_USER, TEST_CHANNEL, TEST_SERVER);
        EXPECT_STRING = "The game testGame do not exist in gamies library. User testBot, testChannel in server testServer";
        //When
        String actualString = LogMessage.cantFindGameLog(con, GAME);
        //Expect
        assertEquals(EXPECT_STRING, actualString);
    }
}
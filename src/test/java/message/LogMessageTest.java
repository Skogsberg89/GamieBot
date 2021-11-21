package message;

import com.gamiebot.listeners.commands.Controller;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LogMessageTest {

    public static Controller con;
    public String EXPECT_STRING;
    public String GAME;

    @BeforeAll
    public static void setUp() {
        String TEST_USER = "testBot";
        String TEST_CHANNEL = "testChannel";
        String TEST_SERVER = "testServer";
        con = new Controller("a message", TEST_USER, TEST_CHANNEL, TEST_SERVER);
    }

    @Test
    @DisplayName("When No game is given, Steam news")
    void noGameLog() {
        //Given
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
        EXPECT_STRING = "The game testGame do not exist in gamies library. User testBot, testChannel in server testServer";
        //When
        String actualString = LogMessage.cantFindGameLog(con, GAME);
        //Expect
        assertEquals(EXPECT_STRING, actualString);
    }

    @Test
    @DisplayName("When input is not recognized")
    void notRecognizedInput() {
        //Given
        String INPUT = "input not exist";
        EXPECT_STRING = "The input (input not exist) that user testBot in channel testChannel in server testServer is not recognized";
        //When
        String actualString = LogMessage.notRecognizedInput(con, INPUT);
        //Expect
        assertEquals(EXPECT_STRING, actualString);
    }
}
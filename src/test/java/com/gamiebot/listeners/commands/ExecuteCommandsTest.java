package com.gamiebot.listeners.commands;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class ExecuteCommandsTest {

    public static Controller con;
    public String EXPECT_STRING;

    private final String TEST_USER = "testBot";
    private final String TEST_CHANNEL = "testChannel";
    private final String TEST_SERVER = "testServer";

    @Test
    @DisplayName("Return help Message")
    void help() {
        //Given
        con = new Controller(".gamie help", TEST_USER, TEST_CHANNEL, TEST_SERVER);
        //Expect
        EXPECT_STRING = "So " + con.getName() + " what can i help you with?";
        assertEquals(EXPECT_STRING, con.getReturnMessage());
    }

    @Test
    @DisplayName("Steam news with no game in input")
    void steamNewsNoGameInput() {
        //Given
        con = new Controller(".gamie -steam news", TEST_USER, TEST_CHANNEL, TEST_SERVER);
        //Expect
        EXPECT_STRING = con.getName() + " Which game do you want news of?\n .game -steam news <game> ";
        assertEquals(EXPECT_STRING, con.getReturnMessage());
    }

    @Test
    @DisplayName("Steam news with game in input")
    void steamNewsGameInput() {
        //Given
        con = new Controller(".gamie -steam news cs", TEST_USER, TEST_CHANNEL, TEST_SERVER);
        //Expect
        assertFalse(con.getTitle().isEmpty());
    }
}
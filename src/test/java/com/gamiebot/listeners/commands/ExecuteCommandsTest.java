package com.gamiebot.listeners.commands;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class ExecuteCommandsTest {

    public static Controller con;
    public String EXPECT_STRING;

    @Test
    @DisplayName("Return help Message")
    void help() {
        //Given
        con = new Controller(".gamie help", "testbot");
        //Expect
        EXPECT_STRING = "So " + con.getName() + " what can i help you with?";
        assertEquals(EXPECT_STRING, con.getReturnMessage());
    }

    @Test
    @DisplayName("Steam news with no game in input")
    void steamNewsNoGameInput() {
        //Given
        con = new Controller(".gamie -steam news", "testbot");
        //Expect
        EXPECT_STRING = con.getName() + " which game do you want news of?\n .game -steam news <game> ";
        assertEquals(EXPECT_STRING, con.getReturnMessage());
    }
}
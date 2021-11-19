package com.gamiebot.listeners.commands;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class ControllerTest {

    public static Controller con;
    public String EXPECT_STRING;

    @BeforeAll
    public static void setUp() {
        String TEST_USER = "testBot";
        String TEST_CHANNEL = "testChannel";
        String TEST_SERVER = "testServer";
        con = new Controller("a message", TEST_USER, TEST_CHANNEL, TEST_SERVER);
    }

    @Test
    void setReturnMessage() {
        //Given
        EXPECT_STRING = "set a message";
        //When
        con.setReturnMessage(EXPECT_STRING);
        //Expect
        assertEquals(EXPECT_STRING,con.getReturnMessage());
    }

    @Test
    void getMessage() {
        //Given
        EXPECT_STRING = "a message";
        //When
        String message = con.getMessage();
        //Expect
        assertEquals(EXPECT_STRING,message);
    }

    @Test
    void getName() {
        EXPECT_STRING = "testBot";
        //When
        String name = con.getName();
        //Expect
        assertEquals(EXPECT_STRING,name);
    }

    @Test
    void getChannel() {
        EXPECT_STRING = "testChannel";
        //When
        String channel = con.getChannel();
        //Expect
        assertEquals(EXPECT_STRING,channel);
    }

    @Test
    void getServer() {
        EXPECT_STRING = "testServer";
        //When
        String server = con.getServer();
        //Expect
        assertEquals(EXPECT_STRING,server);
    }

    @Test
    void setTitle() {
        //Given
        EXPECT_STRING = "TestTitle";
        //When
        con.setTitle(EXPECT_STRING);
        //Expect
        assertEquals(EXPECT_STRING,con.getTitle());
    }

    @Test
    void setColor() {
        //When
        con.setColor(Color.red);
        //Expect
        assertEquals(Color.red,con.getColor());
    }

    @Test
    void setMessageBuilder() {
        //When
        con.setMessageBuilder(true);
        //Expect
        assertTrue(con.isMessageBuilder());
    }

    @Test
    void setIcon() {
        //Given
        EXPECT_STRING = "http://www.icon.com/icon.png";
        //When
        con.setIcon(EXPECT_STRING);
        //Expect
        assertEquals(EXPECT_STRING,con.getIcon());
    }

    @Test
    void setFooter() {
        //Given
        EXPECT_STRING = "this is a footer";
        //When
        con.setFooter(EXPECT_STRING);
        //Expect
        assertEquals(EXPECT_STRING,con.getFooter());
    }

    @Test
    void setUrl() {
        //Given
        EXPECT_STRING = "http://www.url.se";
        //When
        con.setUrl(EXPECT_STRING);
        //Expect
        assertEquals(EXPECT_STRING,con.getUrl());
    }
}
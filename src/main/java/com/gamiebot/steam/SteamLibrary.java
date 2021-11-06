package com.gamiebot.steam;

import java.util.HashMap;
import java.util.Map;

public abstract class SteamLibrary{

    public final Map<String, String> gamesIdDict = new HashMap<>();
    {
        gamesIdDict.put("counter strike", "730");
        gamesIdDict.put("cs", "730");
        gamesIdDict.put("team fortress 2", "440");
        gamesIdDict.put("tf2", "440");
    }

    public final String NEWS_API = "http://api.steampowered.com/ISteamNews/GetNewsForApp/v0002/?appid=%s&count=1&maxlength=300&format=json";
}

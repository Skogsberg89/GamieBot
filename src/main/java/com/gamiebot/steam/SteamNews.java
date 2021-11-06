package com.gamiebot.steam;

import com.gamiebot.listeners.commands.Controller;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;

import java.awt.*;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.text.MessageFormat;

public class SteamNews extends SteamLibrary{

    private final String game;
    private final Controller con;
    private final String gameId;

    public SteamNews(String game, Controller con){
        this.game = game;
        this.con = con;
        gameId = findGameId(this.game);
        getGameNews();
    }

    private String findGameId(String game) {
        return gamesIdDict.get(game);
    }

    private void getGameNews() {
        if(gameId == null){
            con.setReturnMessage(buildErrorMessage());
        }else{
            String path = String.format(NEWS_API, gameId);
            sendRequest(path);
        }
    }

    private String buildErrorMessage() {
        return MessageFormat.format("Sorry {0} !\n I cant find the game {1}", con.getName(), game);
    }

    private void sendRequest(String path) {
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder().uri(URI.create(path)).build();
            String json = client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                    .thenApply(HttpResponse::body)
                    .join();
            JSONObject values = sortResponse(json);
            buildMessage(values);
        }catch (Exception e) {
            con.setReturnMessage("Sorry!\n " + e);
        }
    }

    private JSONObject sortResponse(String responseBody) throws JSONException {
        JSONObject json = new JSONObject(responseBody);
        return json.getJSONObject("appnews")
                .getJSONArray("newsitems")
                .getJSONObject(0);
    }

    private void buildMessage(JSONObject values) throws JSONException {
        con.setTitle((String) values.get("title"));
        con.setReturnMessage((String) values.get("contents"));
        con.setColor(Color.blue);
        con.setUrl((String) values.get("url"));
        con.setIcon("https://seeklogo.com/images/S/steam-logo-73274B19E3-seeklogo.com.png");
        con.setMessageBuilder(true);
    }
}

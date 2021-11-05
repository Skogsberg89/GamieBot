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
import java.util.HashMap;
import java.util.Map;

public class SteamNews {

    private final Map<String, String> apps = new HashMap<>();
    {
        apps.put("counter strike", "730");
        apps.put("cs", "730");
        apps.put("team fortress 2", "440");
        apps.put("tf2", "440");
    }

    private final String app;
    private final Controller con;
    private final String appId;

    public SteamNews(String app, Controller con){
        this.app = app;
        this.con = con;
        appId = findApp();
        getNews();

    }

    private String findApp() {
        for (String a : apps.keySet()) {
            if (a.equals(app)) { return apps.get(a); }
        }
        return "";
    }

    private void getNews() {
        if(appId.isEmpty()){
            con.setReturnMessage(buildErrorMessage());
        }else{
            String path = String.format("http://api.steampowered.com/ISteamNews/GetNewsForApp/v0002/?appid=%s&count=1&maxlength=300&format=json", appId);
            sendRequest(path);
        }
    }

    private String buildErrorMessage() {
        return MessageFormat.format("Sorry {0} !\n I cant find the game {1}", con.getName(), app);
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

package com.gamiebot;

import com.gamiebot.listeners.impl.Listener;
import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class GamiebotApplication {

	@Autowired
	private Environment environment;
	@Autowired
	private Listener listener;

	public static void main(String[] args) {
		SpringApplication.run(GamiebotApplication.class, args);
	}

	@Bean
	@ConfigurationProperties("discord-api")
	public DiscordApi discordApi() {
		String token = environment.getProperty("TOKEN");
		DiscordApi bot = new DiscordApiBuilder().setToken(token)
				.setAllNonPrivilegedIntents()
				.login()
				.join();

		bot.addMessageCreateListener(listener);
		return bot;
	}
}

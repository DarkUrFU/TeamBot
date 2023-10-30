package com.darkurfu.teambot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

@SpringBootApplication
public class TeamBotApplication {

    public static void main(String[] args) throws TelegramApiException {
        SpringApplication.run(TeamBotApplication.class, args);
        TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
        TeamBot bot = new TeamBot();
        botsApi.registerBot(bot);
    }

}

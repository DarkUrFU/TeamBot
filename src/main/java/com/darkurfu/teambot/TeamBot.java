package com.darkurfu.teambot;

import com.darkurfu.teambot.datamodels.CommandData;
import com.darkurfu.teambot.datamodels.UserData;
import com.darkurfu.teambot.service.DataTeamBot;
import commands.CreateMember;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;


public class TeamBot extends TelegramLongPollingBot {
    private DataTeamBot dataTeamBot = new DataTeamBot();
    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            SendMessage message = new SendMessage();
            long chatID = update.getMessage().getChatId();
            String messageText = update.getMessage().getText();
            message.setChatId(String.valueOf(chatID));

            if (update.getMessage().isCommand()) {
                message.setText(readCommand(messageText, chatID));
            } else {
                message.setText(readData(messageText, chatID));
            }

            try {
                execute(message);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }


    }

    private String readData(String text, Long chatID) {
        String message = null;
        try {
            CommandData commandData = dataTeamBot.getData(chatID);
            switch(commandData.getCommandType()) {
                case(1): {
                    UserData userData = (UserData) commandData;
                    userData = CreateMember.update(text, userData);
                    message = userData.chat();
                    dataTeamBot.putData(chatID, userData);
                }
            }
        } catch(RuntimeException e) {
            return("Хз чё случилось");
        } catch(Exception e) {
            return("Хз чё случилось по новой");
        }


        return message;
    }

    private String readCommand(String text, Long chatID) {
        switch(text) {
            case("/create_member"):{
                dataTeamBot.putData(chatID, new UserData(chatID));
                return("Как Вас зовут?");
            }
            case("/create_team"):{
                break;
            }
            case("/update_info"):{
                break;
            }
            case("/find_team"):{
                break;
            }
            case("/find_member"):{
                break;
            }
            case("/match"):{
                break;
            }
            case("/stop"):{
                break;
            }

        }
        return("Я ничё не знаю, давай по новой");
    }

    @Override
    public String getBotUsername() {
        return "FindTeam_DU_bot";
    }

    @Override
    public String getBotToken() {
        return "6431501254:AAFh27YsofZWeFsr2mXDjDMf3e6Hgi3LAhY";
    }
}


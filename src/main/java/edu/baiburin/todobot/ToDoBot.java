package edu.baiburin.todobot;

import edu.baiburin.todobot.config.Config;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class ToDoBot extends TelegramLongPollingBot {
    @Override
    public void onUpdateReceived(Update update) {

        try {
            if (update.hasMessage() && update.getMessage().hasText()) {
                Message inMessage = update.getMessage();
                SendMessage outMessage = new SendMessage();

                outMessage.setChatId(inMessage.getChatId());

                outMessage.setText(inMessage.getText());
                execute(outMessage);

            }
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    public String getBotUsername() {
        return Config.getProperty(Config.BOT_NAME);
    }


    public String getBotToken() {
        return Config.getProperty(Config.BOT_TOKEN);
    }
}

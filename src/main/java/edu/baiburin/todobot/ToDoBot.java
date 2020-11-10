package edu.baiburin.todobot;

import edu.baiburin.todobot.config.Config;
import edu.baiburin.todobot.dao.TaskInserter;
import edu.baiburin.todobot.domain.Task;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.sql.SQLException;
import java.time.LocalDateTime;

public class ToDoBot extends TelegramLongPollingBot {
    @Override
    public void onUpdateReceived(Update update) {

        try {
            if (update.hasMessage() && update.getMessage().hasText()) {
                Message inMessage = update.getMessage();

                Task tsk = new Task();
                tsk.setCreateDate(LocalDateTime.now());
                tsk.setTaskDescription(inMessage.getText());
                // tsk.setAuthorFirstName(inMessage.getContact().getFirstName());
                // tsk.setAuthorLastName(inMessage.getContact().getLastName());
                tsk.setArchived(false);

                TaskInserter taskInserter = new TaskInserter();
                taskInserter.insertTask(tsk);

                SendMessage sendMessage = new SendMessage();
                sendMessage.setChatId(inMessage.getChatId());
                sendMessage.setText("Task added successfully");
                execute(sendMessage);
            }
        } catch (TelegramApiException | SQLException e) {
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

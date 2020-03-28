package com.company.telegrambot.bot.command;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.telegram.telegrambots.extensions.bots.commandbot.commands.BotCommand;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.bots.AbsSender;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

/**
 *  Обработчик для команды старта.
 */
public class StartCommand extends BotCommand {

    private static final String COMMAND = "/start";
    private static final Logger LOGGER = LoggerFactory.getLogger(StartCommand.class);

    public StartCommand() {
        super(COMMAND, "With this command you can start the Bot");
    }

    @Override
    public void execute(AbsSender absSender, User user, Chat chat, String[] strings) {
        SendMessage answer = new SendMessage();
        answer.setChatId(chat.getId().toString());
        answer.setText("Вы можете получить информацию по любому городу. Введите название города.");

        try {
            absSender.execute(answer);
        } catch (TelegramApiException e) {
            LOGGER.error("Error sending message", e);
        }
    }
}

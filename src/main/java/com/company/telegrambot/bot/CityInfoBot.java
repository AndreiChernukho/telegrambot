package com.company.telegrambot.bot;

import com.company.telegrambot.bot.command.StartCommand;
import com.company.telegrambot.city.service.CityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import org.telegram.telegrambots.extensions.bots.commandbot.TelegramLongPollingCommandBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.Optional;

/**
 * Бот возвращающий информацию по городам.
 */
@Component
public class CityInfoBot extends TelegramLongPollingCommandBot {

    private static final Logger LOGGER = LoggerFactory.getLogger(CityInfoBot.class);

    private static final String USER_NAME = "VH5PtAR2U2PsszsTnSlpUyjA0_bot";

    private static final String TOKEN = "1078519732:AAGy5nsCK9HTH-OaJs3t3iBRlEgNPFxnW7I";

    @Autowired
    CityService cityService;

    public CityInfoBot() {
        register(new StartCommand());
    }

    /**
     * Метод для приема сообщений.
     *
     * @param update содержит сообщение от пользователя.
     */
    @Override
    public void processNonCommandUpdate(Update update) {
        String message = update.getMessage().getText();
        sendMessage(update.getMessage().getChatId().toString(), message);
    }

    /**
     * Метод для настройки сообщения и его отправки.
     *
     * @param chatId  id чата
     * @param message входящее сообщение.
     */
    private void sendMessage(String chatId, String message) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.enableMarkdown(true);
        sendMessage.setChatId(chatId);

        String noCityMessage = "К сожалению данного города в нашем справочнике нет. Вы можете ввести другой город.";
        Optional<String> cityDescription = cityService.getDescription(message);

        sendMessage.setText(cityDescription.orElse(noCityMessage));

        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            LOGGER.error("Error sending message", e);
        }
    }

    @Override
    public String getBotUsername() {
        return USER_NAME;
    }

    @Override
    public String getBotToken() {
        return TOKEN;
    }
}

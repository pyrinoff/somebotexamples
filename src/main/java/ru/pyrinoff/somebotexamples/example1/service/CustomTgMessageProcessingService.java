package ru.pyrinoff.somebotexamples.example1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.pyrinoff.somebot.service.bot.tg.TgMessageProcessingService;
import ru.pyrinoff.somebotexamples.example1.api.service.IUserService;
import ru.pyrinoff.somebotexamples.example1.model.CustomTgMessage;
import ru.pyrinoff.somebotexamples.example1.model.User;

@Component
@Primary
public class CustomTgMessageProcessingService extends TgMessageProcessingService<CustomTgMessage> {

    @Autowired
    private IUserService userService;

    @Override
    public void preprocessMessage(final CustomTgMessage message) {
        if (!message.getOriginalMessage().hasMessage()) return;
        Long chatId = message.getOriginalMessage().getMessage().getChatId();
        User user = userService.getUser(chatId);
        if (user == null) {
            user = userService.createUser(chatId);
            if (user == null) {
                logger.error("Cant registerUser!");
                return;
            }
            message.setFirstMessageFromUser(true);
        }
        message.setUser(user);
    }

    @Override
    protected void postProcessMessage(CustomTgMessage message) {
        if(message.hasUser()) userService.saveUser(message.getUser());
    }

    @Override
    protected CustomTgMessage convertUpdateToMessage(Update update) {
        return new CustomTgMessage(update);
    }

}

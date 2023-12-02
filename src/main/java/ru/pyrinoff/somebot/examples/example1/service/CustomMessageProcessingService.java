package ru.pyrinoff.somebot.examples.example1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.pyrinoff.somebot.examples.example1.api.service.IUserService;
import ru.pyrinoff.somebot.examples.example1.model.CustomMessage;
import ru.pyrinoff.somebot.examples.example1.model.User;
import ru.pyrinoff.somebot.service.AbstractMessageProcessingService;

@Component
@Primary
public class CustomMessageProcessingService extends AbstractMessageProcessingService<CustomMessage> {

    @Autowired
    private IUserService userService;

    @Override
    public CustomMessage formMessageByUpdate(final Update update) {
        return new CustomMessage(update);
    }

    @Override
    public void preprocessMessage(final CustomMessage message) {
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
    protected void postProcessMessage(CustomMessage message) {
        if(message.hasUser()) userService.saveUser(message.getUser());
    }


}

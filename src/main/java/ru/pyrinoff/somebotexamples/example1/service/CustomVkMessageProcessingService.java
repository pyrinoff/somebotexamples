package ru.pyrinoff.somebotexamples.example1.service;

import com.vk.api.sdk.objects.callback.MessageObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import com.github.pyrinoff.somebot.service.bot.vk.VkMessageProcessingService;
import ru.pyrinoff.somebotexamples.example1.api.service.IUserService;
import ru.pyrinoff.somebotexamples.example1.model.CustomVkMessage;
import ru.pyrinoff.somebotexamples.example1.model.User;

@Component
@Primary
public class CustomVkMessageProcessingService extends VkMessageProcessingService<CustomVkMessage> {

    @Autowired
    private IUserService userService;

    @Override
    public void preprocessMessage(final CustomVkMessage message) {
        if (message.getOriginalMessage().getMessage() == null) return;
        Long chatId = message.getSenderChatId();
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
    protected void postProcessMessage(CustomVkMessage message) {
        if(message.hasUser()) userService.saveUser(message.getUser());
    }

    @Override
    protected CustomVkMessage convertUpdateToMessage(MessageObject update) {
        return new CustomVkMessage(update);
    }

}

package ru.pyrinoff.somebotexamples.example1.customization.service;

import com.github.pyrinoff.somebot.service.AbstractMessageProcessingService;
import com.github.pyrinoff.somebot.service.bot.vk.api.IVkMessageProcessingService;
import com.vk.api.sdk.objects.callback.MessageObject;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import ru.pyrinoff.somebotexamples.example1.customization.model.CustomUser;
import ru.pyrinoff.somebotexamples.example1.customization.model.CustomVkMessage;

@Component
@Primary
public class CustomVkMessageProcessingService
        extends AbstractMessageProcessingService<MessageObject, CustomUser, CustomVkMessage>
        implements IVkMessageProcessingService {

    @Override
    protected CustomVkMessage convertUpdateToMessage(MessageObject update) {
        return new CustomVkMessage(update);
    }
}

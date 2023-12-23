package ru.pyrinoff.somebotexamples.example1.customization.service;

import com.github.pyrinoff.somebot.service.AbstractMessageProcessingService;
import com.github.pyrinoff.somebot.service.bot.tg.api.ITgMessageProcessingService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.pyrinoff.somebotexamples.example1.customization.model.CustomTgMessage;
import ru.pyrinoff.somebotexamples.example1.customization.model.CustomUser;

@Primary
@Component
public class CustomTgMessageProcessingService
        extends AbstractMessageProcessingService<Update, CustomUser, CustomTgMessage>
        implements ITgMessageProcessingService {

    @Override
    protected CustomTgMessage convertUpdateToMessage(Update update) {
        return new CustomTgMessage(update);
    }
}

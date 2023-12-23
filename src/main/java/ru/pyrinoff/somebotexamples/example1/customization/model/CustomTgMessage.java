package ru.pyrinoff.somebotexamples.example1.customization.model;

import com.github.pyrinoff.somebot.service.bot.tg.abstraction.AbstractTgMessage;
import lombok.Getter;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.Random;

@Getter
public class CustomTgMessage extends AbstractTgMessage<CustomUser> {

    private final boolean userHappy = new Random().nextBoolean();

    public CustomTgMessage(Update originalMessage) {
        super(originalMessage);
    }

}

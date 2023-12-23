package ru.pyrinoff.somebotexamples.example1.customization.model;

import com.github.pyrinoff.somebot.service.bot.vk.abstraction.AbstractVkMessage;
import com.vk.api.sdk.objects.callback.MessageObject;
import lombok.Getter;

import java.util.Random;

@Getter
public class CustomVkMessage extends AbstractVkMessage<CustomUser> {

    private final boolean userHappy = new Random().nextBoolean();

    public CustomVkMessage(MessageObject originalMessage) {
        super(originalMessage);
    }
}

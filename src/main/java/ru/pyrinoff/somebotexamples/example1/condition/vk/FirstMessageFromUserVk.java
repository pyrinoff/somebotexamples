package ru.pyrinoff.somebotexamples.example1.condition.vk;

import com.github.pyrinoff.somebot.service.bot.vk.AbstractVkCondition;
import ru.pyrinoff.somebotexamples.example1.model.CustomVkMessage;

public class FirstMessageFromUserVk implements AbstractVkCondition<CustomVkMessage> {

    public FirstMessageFromUserVk() {}

    @Override
    public boolean isFired(final CustomVkMessage message) {
        return message.isFirstMessageFromUser();
    }

}

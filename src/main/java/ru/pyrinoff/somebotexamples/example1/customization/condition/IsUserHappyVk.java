package ru.pyrinoff.somebotexamples.example1.customization.condition;

import com.github.pyrinoff.somebot.service.bot.vk.api.AbstractVkCondition;
import ru.pyrinoff.somebotexamples.example1.customization.model.CustomUser;
import ru.pyrinoff.somebotexamples.example1.customization.model.CustomVkMessage;

public class IsUserHappyVk implements AbstractVkCondition<CustomUser, CustomVkMessage> {

    @Override
    public boolean isFired(final CustomVkMessage message) {
        return message.isUserHappy();
    }

}

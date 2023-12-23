package ru.pyrinoff.somebotexamples.example1.customization.condition;

import com.github.pyrinoff.somebot.service.bot.tg.api.AbstractTgCondition;
import ru.pyrinoff.somebotexamples.example1.customization.model.CustomTgMessage;
import ru.pyrinoff.somebotexamples.example1.customization.model.CustomUser;

public class IsUserHappyTg implements AbstractTgCondition<CustomUser, CustomTgMessage> {

    @Override
    public boolean isFired(final CustomTgMessage message) {
        return message.isUserHappy();
    }

}

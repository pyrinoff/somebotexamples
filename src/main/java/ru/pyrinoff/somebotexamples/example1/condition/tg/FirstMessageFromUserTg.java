package ru.pyrinoff.somebotexamples.example1.condition.tg;

import org.telegram.telegrambots.meta.api.objects.Update;
import ru.pyrinoff.somebot.api.condition.IConcreteCondition;
import ru.pyrinoff.somebotexamples.example1.model.CustomTgMessage;

public class FirstMessageFromUserTg implements IConcreteCondition<Update, CustomTgMessage> {

    public FirstMessageFromUserTg() {}

    @Override
    public boolean isFired(final CustomTgMessage message) {
        return message.isFirstMessageFromUser();
    }

    @Override
    public Class<Update> getMessageClass() {
        return Update.class;
    }

}

package ru.pyrinoff.somebot.examples.example1.condition;

import ru.pyrinoff.somebot.api.condition.ICondition;
import ru.pyrinoff.somebot.examples.example1.model.CustomMessage;

public class FirstMessageFromUser implements ICondition<CustomMessage> {

    public FirstMessageFromUser() {}

    @Override
    public boolean isFired(final CustomMessage message) {
        return message.isFirstMessageFromUser();
    }

}

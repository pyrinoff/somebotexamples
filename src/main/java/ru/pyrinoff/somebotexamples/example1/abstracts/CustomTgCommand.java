package ru.pyrinoff.somebotexamples.example1.abstracts;

import ru.pyrinoff.somebot.service.bot.tg.AbstractCommandAnyTgMessage;
import ru.pyrinoff.somebotexamples.example1.model.CustomTgMessage;
import ru.pyrinoff.somebotexamples.example1.model.User;

public abstract class CustomTgCommand extends AbstractCommandAnyTgMessage<CustomTgMessage> {

    @Override
    public CustomTgMessage getMessage() {
        return super.getMessage();
    }

    public User getUser() {
        return getMessage().getUser();
    }

}

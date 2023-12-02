package ru.pyrinoff.somebot.examples.example1.abstracts;

import ru.pyrinoff.somebot.abstraction.AbstractCommand;
import ru.pyrinoff.somebot.examples.example1.model.User;
import ru.pyrinoff.somebot.examples.example1.model.CustomMessage;

public abstract class CustomCommand extends AbstractCommand<CustomMessage> {

    @Override
    public CustomMessage getMessage() {
        return super.getMessage();
    }

    public User getUser() {
        return getMessage().getUser();
    }

}

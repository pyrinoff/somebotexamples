package ru.pyrinoff.somebot.examples.example1.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.pyrinoff.somebot.command.condition.MultiRuleset;
import ru.pyrinoff.somebot.command.condition.concrete.HasMessage;
import ru.pyrinoff.somebot.examples.example1.abstracts.CustomCommand;
import ru.pyrinoff.somebot.examples.example1.api.service.IUserService;
import ru.pyrinoff.somebot.examples.example1.command.priority.CommandPriority;
import ru.pyrinoff.somebot.examples.example1.condition.HasStage;

import java.util.ArrayList;

import static ru.pyrinoff.somebot.examples.example1.model.User.STAGE_NONE;

@Component
public class DefaultStage extends CustomCommand {

    public static final String TEXT_SHOW_YOUR_BIRTHDATE = "Ваша дата рождения: ";

    @Autowired IUserService userService;

    @Override
    public int getPriority() {
        return CommandPriority.DEFAULT_STAGE.ordinal();
    }

    @Override
    public ArrayList<MultiRuleset> setupFireConditions() {
        return fireConditions(multiRuleset(ruleset(new HasMessage(), new HasStage(STAGE_NONE))));
    }

    @Override
    public void process() {
        getTelegramBot().sendMessageBack(getOriginalMessage(), TEXT_SHOW_YOUR_BIRTHDATE + getUser().getBirthDate(), true);
        getUser().setDefaultStage();
    }

}

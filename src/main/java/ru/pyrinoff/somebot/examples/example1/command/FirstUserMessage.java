package ru.pyrinoff.somebot.examples.example1.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.pyrinoff.somebot.command.condition.MultiRuleset;
import ru.pyrinoff.somebot.examples.example1.abstracts.CustomCommand;
import ru.pyrinoff.somebot.examples.example1.api.service.IUserService;
import ru.pyrinoff.somebot.examples.example1.command.priority.CommandPriority;
import ru.pyrinoff.somebot.examples.example1.condition.FirstMessageFromUser;

import java.util.ArrayList;

@Component
public class FirstUserMessage extends CustomCommand {

    @Autowired IUserService userService;

    @Override
    public int getPriority() {
        return CommandPriority.FIRST_MESSAGE.ordinal();
    }

    @Override
    public ArrayList<MultiRuleset> setupFireConditions() {
        return fireConditions(multiRuleset(ruleset(new FirstMessageFromUser())));
    }

    @Override
    public void process() {
        getUser().setStage(CheckBirthday.STAGE_BIRTHDAY_1_PLEASE_ENTER);
        logger.info("Current stage in message (command): " +  getUser().getStage());
        getMessage().setFirstMessageFromUser(false);
        setProceedNextCommand(false);
        setProcessNewCircle(true);
    }

}

package ru.pyrinoff.somebotexamples.example1.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Update;
import com.github.pyrinoff.somebot.command.condition.MultiRuleset;
import ru.pyrinoff.somebotexamples.example1.abstracts.CustomTgCommand;
import ru.pyrinoff.somebotexamples.example1.api.service.IUserService;
import ru.pyrinoff.somebotexamples.example1.command.priority.CommandPriority;
import ru.pyrinoff.somebotexamples.example1.condition.tg.FirstMessageFromUserTg;
import ru.pyrinoff.somebotexamples.example1.model.CustomTgMessage;

import java.util.ArrayList;

@Component
public class FirstUserMessageTg extends CustomTgCommand {

    @Autowired
    IUserService userService;

    @Override
    public int getPriority() {
        return CommandPriority.FIRST_MESSAGE.ordinal();
    }

    @Override
    public ArrayList<MultiRuleset<Update, CustomTgMessage>> setupFireConditions() {
        return fireConditions(multiRuleset(ruleset(new FirstMessageFromUserTg())));
    }

    @Override
    public void process() {
        getUser().setStage(CheckBirthdayVk.STAGE_BIRTHDAY_1_PLEASE_ENTER);
//        logger.info("Current stage in message (command): " +  getUser().getStage());
        getMessage().setFirstMessageFromUser(false);
        setProceedNextCommand(false);
        setProcessNewCircle(true);
    }

}

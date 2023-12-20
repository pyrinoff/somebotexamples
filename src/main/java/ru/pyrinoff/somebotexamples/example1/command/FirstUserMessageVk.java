package ru.pyrinoff.somebotexamples.example1.command;

import com.vk.api.sdk.objects.callback.MessageObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.github.pyrinoff.somebot.command.condition.MultiRuleset;
import ru.pyrinoff.somebotexamples.example1.abstracts.CustomVkCommand;
import ru.pyrinoff.somebotexamples.example1.api.service.IUserService;
import ru.pyrinoff.somebotexamples.example1.command.priority.CommandPriority;
import ru.pyrinoff.somebotexamples.example1.condition.tg.FirstMessageFromUserVk;
import ru.pyrinoff.somebotexamples.example1.model.CustomVkMessage;

import java.util.ArrayList;

@Component
public class FirstUserMessageVk extends CustomVkCommand {

    @Autowired
    IUserService userService;

    @Override
    public int getPriority() {
        return CommandPriority.FIRST_MESSAGE.ordinal();
    }

    @Override
    public ArrayList<MultiRuleset<MessageObject, CustomVkMessage>> setupFireConditions() {
        return fireConditions(multiRuleset(ruleset(new FirstMessageFromUserVk())));
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

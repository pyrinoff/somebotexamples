package ru.pyrinoff.somebotexamples.example1.command.withstage;

import com.github.pyrinoff.somebot.command.condition.MultiRuleset;
import com.github.pyrinoff.somebot.service.IUserService;
import com.github.pyrinoff.somebot.service.bot.tg.concrete.condition.FirstMessageFromUserTg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.pyrinoff.somebotexamples.example1.command.priority.CommandPriority;
import ru.pyrinoff.somebotexamples.example1.customization.abstracts.CustomTgCommand;
import ru.pyrinoff.somebotexamples.example1.customization.model.CustomTgMessage;
import ru.pyrinoff.somebotexamples.example1.customization.model.CustomUser;

import java.util.ArrayList;

@Component
public class FirstUserMessageTg extends CustomTgCommand {

    @Autowired
    IUserService<CustomUser> userService;

    @Override
    public int getPriority() {
        return CommandPriority.FIRST_MESSAGE.ordinal();
    }

    @Override
    public ArrayList<MultiRuleset<Update, CustomUser, CustomTgMessage>> setupFireConditions() {
        return fireConditions(multiRuleset(ruleset(new FirstMessageFromUserTg())));
    }

    @Override
    public void process() {
        getMessage().getUser().setStage(CheckBirthdayTg.STAGE_BIRTHDAY_1_PLEASE_ENTER);
        getMessage().setFirstMessageFromUser(false);
        setProceedNextCommand(false);
        setProcessNewCircle(true);
    }

}

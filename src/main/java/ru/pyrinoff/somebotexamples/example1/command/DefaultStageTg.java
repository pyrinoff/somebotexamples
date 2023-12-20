package ru.pyrinoff.somebotexamples.example1.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.pyrinoff.somebot.command.condition.MultiRuleset;
import ru.pyrinoff.somebot.service.bot.tg.condition.concrete.HasMessageTg;
import ru.pyrinoff.somebotexamples.example1.abstracts.CustomTgCommand;
import ru.pyrinoff.somebotexamples.example1.api.service.IUserService;
import ru.pyrinoff.somebotexamples.example1.command.priority.CommandPriority;
import ru.pyrinoff.somebotexamples.example1.condition.tg.HasStageTg;
import ru.pyrinoff.somebotexamples.example1.model.CustomTgMessage;
import ru.pyrinoff.somebotexamples.example1.model.User;

import java.util.ArrayList;

@Component
public class DefaultStageTg extends CustomTgCommand {

    public static final String TEXT_SHOW_YOUR_BIRTHDATE = "Ваша дата рождения: ";

    @Autowired
    IUserService userService;

    @Override
    public int getPriority() {
        return CommandPriority.DEFAULT_STAGE.ordinal();
    }

    @Override
    public ArrayList<MultiRuleset<Update, CustomTgMessage>> setupFireConditions() {
        return fireConditions(multiRuleset(ruleset(new HasMessageTg<>(), new HasStageTg(User.STAGE_NONE))));
    }

    @Override
    public void process() {
        getBot().sendMessageBack(getOriginalMessage(), TEXT_SHOW_YOUR_BIRTHDATE + userService.getUser(getMessage().getSenderChatId()).getBirthDate(), false);
    }

}

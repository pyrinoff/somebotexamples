package ru.pyrinoff.somebotexamples.example1.command;

import com.vk.api.sdk.objects.callback.MessageObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.pyrinoff.somebot.command.condition.MultiRuleset;
import ru.pyrinoff.somebot.service.bot.vk.condition.concrete.HasMessageVk;
import ru.pyrinoff.somebotexamples.example1.abstracts.CustomVkCommand;
import ru.pyrinoff.somebotexamples.example1.api.service.IUserService;
import ru.pyrinoff.somebotexamples.example1.command.priority.CommandPriority;
import ru.pyrinoff.somebotexamples.example1.condition.vk.HasStageVk;
import ru.pyrinoff.somebotexamples.example1.model.CustomVkMessage;
import ru.pyrinoff.somebotexamples.example1.model.User;

import java.util.ArrayList;

@Component
public class DefaultStageVk extends CustomVkCommand {

    public static final String TEXT_SHOW_YOUR_BIRTHDATE = "Ваша дата рождения: ";

    @Autowired
    IUserService userService;

    @Override
    public int getPriority() {
        return CommandPriority.DEFAULT_STAGE.ordinal();
    }

    @Override
    public ArrayList<MultiRuleset<MessageObject, CustomVkMessage>> setupFireConditions() {
        return fireConditions(multiRuleset(ruleset(new HasMessageVk<>(), new HasStageVk(User.STAGE_NONE))));
    }

    @Override
    public void process() {
        getBot().sendMessageBack(getMessage(), TEXT_SHOW_YOUR_BIRTHDATE + userService.getUser(getMessage().getSenderChatId()).getBirthDate(), false);
    }

}

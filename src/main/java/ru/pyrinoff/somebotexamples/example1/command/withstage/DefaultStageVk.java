package ru.pyrinoff.somebotexamples.example1.command.withstage;

import com.github.pyrinoff.somebot.command.condition.MultiRuleset;
import com.github.pyrinoff.somebot.model.User;
import com.github.pyrinoff.somebot.service.bot.vk.concrete.condition.HasMessageVk;
import com.github.pyrinoff.somebot.service.bot.vk.concrete.condition.HasStageVk;
import com.vk.api.sdk.objects.callback.MessageObject;
import org.springframework.stereotype.Component;
import ru.pyrinoff.somebotexamples.example1.command.priority.CommandPriority;
import ru.pyrinoff.somebotexamples.example1.customization.abstracts.CustomVkCommand;
import ru.pyrinoff.somebotexamples.example1.customization.model.CustomUser;
import ru.pyrinoff.somebotexamples.example1.customization.model.CustomVkMessage;

import java.util.ArrayList;

@Component
public class DefaultStageVk extends CustomVkCommand {

    @Override
    public int getPriority() {
        return CommandPriority.DEFAULT_STAGE.ordinal();
    }

    @Override
    public ArrayList<MultiRuleset<MessageObject, CustomUser, CustomVkMessage>> setupFireConditions() {
        return fireConditions(multiRuleset(ruleset(new HasMessageVk<>(), new HasStageVk(User.STAGE_NONE))));
    }

    @Override
    public void process() {
        final String dateOfBirth = (!getMessage().hasUser() || getMessage().getUser().getBirthDate() == null)
                ? ru.pyrinoff.somebotexamples.example1.command.withstage.DefaultStageTg.DATE_UNKNOWN
                : getMessage().getUser().getBirthDate().toString();
        getBot().sendMessageBack(getOriginalMessage(), DefaultStageTg.TEXT_SHOW_YOUR_BIRTHDATE + dateOfBirth, false);
    }

}

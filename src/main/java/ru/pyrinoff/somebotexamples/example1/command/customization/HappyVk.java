package ru.pyrinoff.somebotexamples.example1.command.customization;

import com.github.pyrinoff.somebot.command.condition.MultiRuleset;
import com.vk.api.sdk.objects.callback.MessageObject;
import org.springframework.stereotype.Component;
import ru.pyrinoff.somebotexamples.example1.command.priority.CommandPriority;
import ru.pyrinoff.somebotexamples.example1.customization.abstracts.CustomVkCommand;
import ru.pyrinoff.somebotexamples.example1.customization.condition.IsUserHappyVk;
import ru.pyrinoff.somebotexamples.example1.customization.model.CustomUser;
import ru.pyrinoff.somebotexamples.example1.customization.model.CustomVkMessage;

import java.util.ArrayList;

@Component
public class HappyVk extends CustomVkCommand {

    @Override
    public int getPriority() {
        return CommandPriority.HAPPY.ordinal();
    }

    @Override
    public ArrayList<MultiRuleset<MessageObject, CustomUser, CustomVkMessage>> setupFireConditions() {
        return fireConditions(multiRuleset(ruleset(new IsUserHappyVk())));
    }

    @Override
    public void process() {
        getBot().sendMessageBack(getOriginalMessage(), HappyTg.MESSAGE_WORKS, false
        );
    }

}

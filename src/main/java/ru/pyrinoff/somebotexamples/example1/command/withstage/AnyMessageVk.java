package ru.pyrinoff.somebotexamples.example1.command.withstage;

import com.github.pyrinoff.somebot.command.condition.MultiRuleset;
import com.github.pyrinoff.somebot.service.bot.vk.concrete.condition.HasMessageVk;
import com.vk.api.sdk.objects.callback.MessageObject;
import org.springframework.stereotype.Component;
import ru.pyrinoff.somebotexamples.example1.command.priority.CommandPriority;
import ru.pyrinoff.somebotexamples.example1.customization.abstracts.CustomVkCommand;
import ru.pyrinoff.somebotexamples.example1.customization.model.CustomUser;
import ru.pyrinoff.somebotexamples.example1.customization.model.CustomVkMessage;

import java.util.ArrayList;

@Component
public class AnyMessageVk extends CustomVkCommand {

    @Override
    public int getPriority() {
        return CommandPriority.ANY_MESSAGE.ordinal();
    }

    @Override
    public ArrayList<MultiRuleset<MessageObject, CustomUser, CustomVkMessage>> setupFireConditions() {
        return fireConditions(multiRuleset(ruleset(new HasMessageVk<>())));
    }

    @Override
    public void process() {
        System.out.println("Got VK message");
    }

}

package ru.pyrinoff.somebotexamples.example1.command;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.pyrinoff.somebot.command.condition.MultiRuleset;
import ru.pyrinoff.somebot.service.bot.tg.condition.concrete.HasMessageTg;
import ru.pyrinoff.somebotexamples.example1.abstracts.CustomTgCommand;
import ru.pyrinoff.somebotexamples.example1.command.priority.CommandPriority;
import ru.pyrinoff.somebotexamples.example1.model.CustomTgMessage;

import java.util.ArrayList;

@Component
public class AnyMessageTg extends CustomTgCommand {

    @Override
    public int getPriority() {
        return CommandPriority.ANY_MESSAGE.ordinal();
    }

    @Override
    public ArrayList<MultiRuleset<Update, CustomTgMessage>> setupFireConditions() {
        return fireConditions(multiRuleset(ruleset(new HasMessageTg<>())));
    }

    @Override
    public void process() {
        System.out.println("Got TG message");
    }

}

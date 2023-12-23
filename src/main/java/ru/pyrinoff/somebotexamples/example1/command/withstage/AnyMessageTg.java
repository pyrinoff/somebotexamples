package ru.pyrinoff.somebotexamples.example1.command.withstage;

import com.github.pyrinoff.somebot.command.condition.MultiRuleset;
import com.github.pyrinoff.somebot.service.bot.tg.concrete.condition.HasMessageTg;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.pyrinoff.somebotexamples.example1.command.priority.CommandPriority;
import ru.pyrinoff.somebotexamples.example1.customization.abstracts.CustomTgCommand;
import ru.pyrinoff.somebotexamples.example1.customization.model.CustomTgMessage;
import ru.pyrinoff.somebotexamples.example1.customization.model.CustomUser;

import java.util.ArrayList;

@Component
public class AnyMessageTg extends CustomTgCommand {

    @Override
    public int getPriority() {
        return CommandPriority.ANY_MESSAGE.ordinal();
    }

    @Override
    public ArrayList<MultiRuleset<Update, CustomUser, CustomTgMessage>> setupFireConditions() {
        return fireConditions(multiRuleset(ruleset(new HasMessageTg<>())));
    }


    @Override
    public void process() {
        System.out.println("Got TG message");
    }

}

package ru.pyrinoff.somebotexamples.example1.command.customization;

import com.github.pyrinoff.somebot.command.condition.MultiRuleset;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.pyrinoff.somebotexamples.example1.command.priority.CommandPriority;
import ru.pyrinoff.somebotexamples.example1.customization.abstracts.CustomTgCommand;
import ru.pyrinoff.somebotexamples.example1.customization.condition.IsUserHappyTg;
import ru.pyrinoff.somebotexamples.example1.customization.model.CustomTgMessage;
import ru.pyrinoff.somebotexamples.example1.customization.model.CustomUser;

import java.util.ArrayList;

@Component
public class HappyTg extends CustomTgCommand {

    public static final String MESSAGE_WORKS = "HAPPY. Custom message works!";

    @Override
    public int getPriority() {
        return CommandPriority.HAPPY.ordinal();
    }

    @Override
    public ArrayList<MultiRuleset<Update, CustomUser, CustomTgMessage>> setupFireConditions() {
        return fireConditions(multiRuleset(ruleset(new IsUserHappyTg())));
    }

    @Override
    public void process() {
        getBot().sendMessageBack(getOriginalMessage(), MESSAGE_WORKS, false
        );
    }

}

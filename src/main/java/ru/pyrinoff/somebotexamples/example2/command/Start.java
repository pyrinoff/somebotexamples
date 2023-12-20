package ru.pyrinoff.somebotexamples.example2.command;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.pyrinoff.somebot.command.condition.MultiRuleset;
import ru.pyrinoff.somebot.service.bot.tg.AbstractCommandTgMessage;
import ru.pyrinoff.somebot.service.bot.tg.TgMessage;
import ru.pyrinoff.somebot.service.bot.tg.condition.concrete.HasTextEqualsTg;

import java.util.ArrayList;

@Component
public class Start extends AbstractCommandTgMessage {

    @Override
    public int getPriority() {
        return CommandPriority.EXAMPLE.ordinal();
    }

    @Override
    public ArrayList<MultiRuleset<Update, TgMessage>> setupFireConditions() {
        return fireConditions(multiRuleset(ruleset(new HasTextEqualsTg("/start"))));
    }

    @Override
    public void process() {
        getBot().sendMessageBack(getOriginalMessage(), "Start message answer", true);
    }

}

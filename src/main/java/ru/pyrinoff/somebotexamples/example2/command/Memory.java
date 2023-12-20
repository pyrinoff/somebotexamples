package ru.pyrinoff.somebotexamples.example2.command;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Update;
import com.github.pyrinoff.somebot.command.condition.MultiRuleset;
import com.github.pyrinoff.somebot.service.bot.tg.AbstractCommandTgMessage;
import com.github.pyrinoff.somebot.service.bot.tg.TgMessage;
import com.github.pyrinoff.somebot.service.bot.tg.condition.concrete.HasTextEqualsTg;
import ru.pyrinoff.somebotexamples.example2.util.MemoryUsageUtil;

import java.util.ArrayList;

@Component
public class Memory extends AbstractCommandTgMessage {

    @Override
    public int getPriority() {
        return CommandPriority.MEMORY.ordinal();
    }

    @Override
    public ArrayList<MultiRuleset<Update, TgMessage>> setupFireConditions() {
        return fireConditions(multiRuleset(ruleset(new HasTextEqualsTg("/memory"))));
    }

    @Override
    public void process() {
        getBot().sendMessageBack(getOriginalMessage(), "Memory usage: " + MemoryUsageUtil.getMemoryUsageMb(), true);
    }

}

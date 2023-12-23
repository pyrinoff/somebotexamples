package ru.pyrinoff.somebotexamples.example1.command.util;

import com.github.pyrinoff.somebot.command.condition.MultiRuleset;
import com.github.pyrinoff.somebot.model.User;
import com.github.pyrinoff.somebot.service.bot.tg.concrete.CommandForTgMessage;
import com.github.pyrinoff.somebot.service.bot.tg.concrete.TgMessage;
import com.github.pyrinoff.somebot.service.bot.tg.concrete.condition.HasTextEqualsTg;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.pyrinoff.somebotexamples.example1.command.priority.CommandPriority;
import ru.pyrinoff.somebotexamples.example1.util.MemoryUsageUtil;

import java.util.ArrayList;

@Component
public class MemoryTg extends CommandForTgMessage {

    @Override
    public int getPriority() {
        return CommandPriority.MEMORY.ordinal();
    }

    @Override
    public ArrayList<MultiRuleset<Update, User, TgMessage>> setupFireConditions() {
        return fireConditions(multiRuleset(ruleset(new HasTextEqualsTg<>("/memory"))));
    }

    @Override
    public void process() {
        getBot().sendMessageBack(getOriginalMessage(), "Memory usage: " + MemoryUsageUtil.getMemoryUsageMb(), true);
    }

}

package ru.pyrinoff.somebotexamples.example1.command.util;

import com.github.pyrinoff.somebot.command.condition.MultiRuleset;
import com.github.pyrinoff.somebot.model.User;
import com.github.pyrinoff.somebot.service.bot.tg.concrete.CommandForTgMessage;
import com.github.pyrinoff.somebot.service.bot.tg.concrete.TgMessage;
import com.github.pyrinoff.somebot.service.bot.tg.concrete.condition.HasTextEqualsTg;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.pyrinoff.somebotexamples.example1.command.priority.CommandPriority;

import java.util.ArrayList;

@Component
public class WhoisTg extends CommandForTgMessage {

    @Override
    public int getPriority() {
        return CommandPriority.WHOIS.ordinal();
    }

    @Override
    public ArrayList<MultiRuleset<Update, User, TgMessage>> setupFireConditions() {
        return fireConditions(multiRuleset(ruleset(new HasTextEqualsTg<>("/whois"))));
    }

    @Override
    public void process() {
        getBot().sendMessageBack(getOriginalMessage(),
                "Your chat id is: " + getOriginalMessage().getMessage().getChatId() + "\n"
                        + "You user id: " + getOriginalMessage().getMessage().getFrom().getId() + "\n"
                        + "Your username: '" + getOriginalMessage().getMessage().getFrom().getUserName() + "'\n"
                        + "Your name: '" + getOriginalMessage().getMessage().getFrom().getFirstName() + " "
                        + getOriginalMessage().getMessage().getFrom().getLastName() + "'\n"
                , true
        );
    }

}

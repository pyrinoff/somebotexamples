package ru.pyrinoff.somebotexamples.example2.command;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.pyrinoff.somebot.command.condition.MultiRuleset;
import ru.pyrinoff.somebot.service.bot.tg.AbstractCommandTgMessage;
import ru.pyrinoff.somebot.service.bot.tg.TgMessage;
import ru.pyrinoff.somebot.service.bot.tg.condition.concrete.HasTextEqualsTg;

import java.util.ArrayList;

@Component
public class Whois extends AbstractCommandTgMessage {

    @Override
    public int getPriority() {
        return CommandPriority.WHOIS.ordinal();
    }

    @Override
    public ArrayList<MultiRuleset<Update, TgMessage>> setupFireConditions() {
        return fireConditions(multiRuleset(ruleset(new HasTextEqualsTg("/whois"))));
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

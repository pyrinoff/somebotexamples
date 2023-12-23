package ru.pyrinoff.somebotexamples.example1.command.withstage;

import com.github.pyrinoff.somebot.command.condition.MultiRuleset;
import com.github.pyrinoff.somebot.service.bot.tg.concrete.condition.HasMessageTg;
import com.github.pyrinoff.somebot.service.bot.tg.concrete.condition.HasStageTg;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.pyrinoff.somebotexamples.example1.command.priority.CommandPriority;
import ru.pyrinoff.somebotexamples.example1.customization.abstracts.CustomTgCommand;
import ru.pyrinoff.somebotexamples.example1.customization.model.CustomTgMessage;
import ru.pyrinoff.somebotexamples.example1.customization.model.CustomUser;

import java.util.ArrayList;

@Component
public class DefaultStageTg extends CustomTgCommand {

    public static final String TEXT_SHOW_YOUR_BIRTHDATE = "Ваша дата рождения: ";
    public static final String DATE_UNKNOWN = "неизвестна";

    @Override
    public int getPriority() {
        return CommandPriority.DEFAULT_STAGE.ordinal();
    }

    @Override
    public ArrayList<MultiRuleset<Update, CustomUser, CustomTgMessage>> setupFireConditions() {
        return fireConditions(multiRuleset(ruleset(new HasMessageTg<>(), new HasStageTg(CustomUser.STAGE_NONE))));
    }

    @Override
    public void process() {
        final String dateOfBirth = (!getMessage().hasUser() || getMessage().getUser().getBirthDate() == null)
                ? DATE_UNKNOWN
                :  getMessage().getUser().getBirthDate().toString();
        getBot().sendMessageBack(getOriginalMessage(), TEXT_SHOW_YOUR_BIRTHDATE + dateOfBirth, false
        );
    }

}

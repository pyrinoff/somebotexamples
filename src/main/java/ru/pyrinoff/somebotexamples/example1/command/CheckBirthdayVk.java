package ru.pyrinoff.somebotexamples.example1.command;

import com.vk.api.sdk.objects.callback.MessageObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.pyrinoff.somebot.command.condition.MultiRuleset;
import ru.pyrinoff.somebotexamples.example1.abstracts.CustomVkCommand;
import ru.pyrinoff.somebotexamples.example1.api.service.IUserService;
import ru.pyrinoff.somebotexamples.example1.command.priority.CommandPriority;
import ru.pyrinoff.somebotexamples.example1.condition.vk.HasStageVk;
import ru.pyrinoff.somebotexamples.example1.model.CustomVkMessage;
import ru.pyrinoff.somebotexamples.example1.util.DateUtil;

import java.time.LocalDate;
import java.util.ArrayList;

@Component
public class CheckBirthdayVk extends CustomVkCommand {

    public static final String TEXT_ENTER_BIRTHDATE = "Введите вашу дату рождения в формате: 23.12.2001";
    public static final String TEXT_WRONG_ERROR_BIRTHDATE_FORMAT = "Неверный формат. Попробуйте еще раз.";
    public static final String TEXT_OLD = "Ого, у вас почтенный возраст!";
    public static final String TEXT_YOUNG = "Вы молоды!";
    public static final String TEXT_OKAY = "Вы в самом расцвете сил!";

    public static final int YEAR_MIN = 16;
    public static final int YEAR_MAX = 100;

    public static final String PATTERN_BIRTH_DATE = "[d.M.yyyy][d-M-yyyy][d M yyyy]";

    @Autowired
    IUserService userService;

     @Override
    public int getPriority() {
        return CommandPriority.CHECK_BIRTHDAY.ordinal();
    }

    public static int STAGE_BIRTHDAY_1_PLEASE_ENTER = 100;
    public static int STAGE_BIRTHDAY_2_WAITING_FOR_ENTER = 101;

    @Override
    public ArrayList<MultiRuleset<MessageObject, CustomVkMessage>> setupFireConditions() {
        return fireConditions(multiRuleset(ruleset(new HasStageVk(STAGE_BIRTHDAY_1_PLEASE_ENTER, STAGE_BIRTHDAY_2_WAITING_FOR_ENTER))));
    }

    @Override
    public void process() {
        if(getUser().getStage() == STAGE_BIRTHDAY_1_PLEASE_ENTER) {
            getBot().sendMessageBack(getMessage(), TEXT_ENTER_BIRTHDATE, true);
            getUser().setStage(STAGE_BIRTHDAY_2_WAITING_FOR_ENTER);
            return;
        }
        if(getUser().getStage() == STAGE_BIRTHDAY_2_WAITING_FOR_ENTER) {
            final String textMessage = getMessage().getText();
            final LocalDate localDate = DateUtil.getLocalDate(textMessage, PATTERN_BIRTH_DATE);
            if(localDate == null) {
                getBot().sendMessageBack(getMessage(), TEXT_WRONG_ERROR_BIRTHDATE_FORMAT, true);
                return;
            }
            getUser().setBirthDate(localDate);
            getUser().setDefaultStage();
            if(!DateUtil.isAgeOver(localDate, YEAR_MIN, true)) {
                getBot().sendMessageBack(getMessage(), TEXT_YOUNG, true);
                return;
            }
            if(DateUtil.isAgeOver(localDate, YEAR_MAX, false)) {
                getBot().sendMessageBack(getMessage(), TEXT_OLD, true);
                return;
            }
            getBot().sendMessageBack(getMessage(), TEXT_OKAY, true);
        }
    }

}

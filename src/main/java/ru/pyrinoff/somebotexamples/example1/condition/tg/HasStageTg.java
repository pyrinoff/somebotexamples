package ru.pyrinoff.somebotexamples.example1.condition.tg;

import com.github.pyrinoff.somebot.service.bot.tg.condition.AbstractTgCondition;
import ru.pyrinoff.somebotexamples.example1.model.CustomTgMessage;

import java.util.Arrays;

public class HasStageTg implements AbstractTgCondition<CustomTgMessage> {

    final int[] stages;

    public HasStageTg(int...stages) {
        this.stages = stages;
    }

    @Override
    public boolean isFired(final CustomTgMessage message) {
        return message.hasUser() && Arrays.binarySearch(stages, message.getUser().getStage()) >=0;
    }

}

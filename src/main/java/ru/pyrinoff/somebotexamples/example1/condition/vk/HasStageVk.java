package ru.pyrinoff.somebotexamples.example1.condition.vk;

import ru.pyrinoff.somebot.service.bot.vk.AbstractVkCondition;
import ru.pyrinoff.somebotexamples.example1.model.CustomVkMessage;

import java.util.Arrays;

public class HasStageVk implements AbstractVkCondition<CustomVkMessage> {

    final int[] stages;

    public HasStageVk(int...stages) {
        this.stages = stages;
    }

    @Override
    public boolean isFired(final CustomVkMessage message) {
        return message.hasUser() && Arrays.binarySearch(stages, message.getUser().getStage()) >=0;
    }

}

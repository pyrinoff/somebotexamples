package ru.pyrinoff.somebot.examples.example1.condition;

import ru.pyrinoff.somebot.api.condition.ICondition;
import ru.pyrinoff.somebot.examples.example1.model.CustomMessage;

import java.util.Arrays;

public class HasStage implements ICondition<CustomMessage> {

    final int[] stages;

    public HasStage(int...stages) {
        this.stages = stages;
    }

    @Override
    public boolean isFired(final CustomMessage message) {
        return message.hasUser() && Arrays.binarySearch(stages, message.getUser().getStage()) >=0;
    }

}

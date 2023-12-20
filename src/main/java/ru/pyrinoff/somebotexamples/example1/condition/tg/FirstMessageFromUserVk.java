package ru.pyrinoff.somebotexamples.example1.condition.tg;

import com.vk.api.sdk.objects.callback.MessageObject;
import ru.pyrinoff.somebot.api.condition.IConcreteCondition;
import ru.pyrinoff.somebotexamples.example1.model.CustomVkMessage;

public class FirstMessageFromUserVk implements IConcreteCondition<MessageObject, CustomVkMessage> {

    public FirstMessageFromUserVk() {}

    @Override
    public boolean isFired(final CustomVkMessage message) {
        return message.isFirstMessageFromUser();
    }

    @Override
    public Class<MessageObject> getMessageClass() {
        return MessageObject.class;
    }

}

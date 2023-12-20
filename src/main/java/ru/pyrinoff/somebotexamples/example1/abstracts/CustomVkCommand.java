package ru.pyrinoff.somebotexamples.example1.abstracts;

import com.vk.api.sdk.objects.callback.MessageObject;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import com.github.pyrinoff.somebot.abstraction.AbstractCommand;
import com.github.pyrinoff.somebot.service.bot.vk.VkBot;
import ru.pyrinoff.somebotexamples.example1.model.CustomVkMessage;
import ru.pyrinoff.somebotexamples.example1.model.User;

public abstract class CustomVkCommand extends AbstractCommand<MessageObject, CustomVkMessage> {

    @Autowired
    @Lazy
    @Getter
    private VkBot bot;


    @Override
    public CustomVkMessage getMessage() {
        return super.getMessage();
    }

    public User getUser() {
        return getMessage().getUser();
    }

}

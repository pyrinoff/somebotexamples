package ru.pyrinoff.somebotexamples.example1.model;

import com.vk.api.sdk.objects.callback.MessageObject;
import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.Nullable;
import ru.pyrinoff.somebot.service.bot.vk.VkMessage;

@Getter
public class CustomVkMessage extends VkMessage {

    public CustomVkMessage(MessageObject originalMessage) {
        super(originalMessage);
    }

    @Nullable User user;

    @Setter
    boolean firstMessageFromUser = false;

    public CustomVkMessage setUser(User user) {
        this.user = user;
        return this;
    }

    public boolean hasUser() {
        return user != null;
    }

}

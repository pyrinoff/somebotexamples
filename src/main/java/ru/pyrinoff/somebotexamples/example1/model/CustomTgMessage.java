package ru.pyrinoff.somebotexamples.example1.model;

import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.telegram.telegrambots.meta.api.objects.Update;
import com.github.pyrinoff.somebot.service.bot.tg.TgMessage;

@Getter
public class CustomTgMessage extends TgMessage {

    public CustomTgMessage(@NotNull Update originalMessage) {
        super(originalMessage);
    }

    @Nullable User user;

    @Setter
    boolean firstMessageFromUser = false;

    public CustomTgMessage setUser(User user) {
        this.user = user;
        return this;
    }

    public boolean hasUser() {
        return user != null;
    }

}

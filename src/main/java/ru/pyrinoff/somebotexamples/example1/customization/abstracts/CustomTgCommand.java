package ru.pyrinoff.somebotexamples.example1.customization.abstracts;


import com.github.pyrinoff.somebot.service.bot.tg.abstraction.AbstractCommandTgMessage;
import ru.pyrinoff.somebotexamples.example1.customization.model.CustomTgMessage;
import ru.pyrinoff.somebotexamples.example1.customization.model.CustomUser;

public abstract class CustomTgCommand extends AbstractCommandTgMessage<CustomUser, CustomTgMessage> {

}

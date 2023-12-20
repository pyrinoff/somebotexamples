package ru.pyrinoff.somebotexamples.example1.api.service;

import org.jetbrains.annotations.Nullable;
import ru.pyrinoff.somebotexamples.example1.model.User;

public interface IUserService {

    User createUser(Long chatId);

    User getUser(Long chatId);

    User saveUser(@Nullable User user);

}

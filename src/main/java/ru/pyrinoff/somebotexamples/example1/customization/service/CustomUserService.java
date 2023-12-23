package ru.pyrinoff.somebotexamples.example1.customization.service;

import com.github.pyrinoff.somebot.service.AbstractUserService;
import com.github.pyrinoff.somebot.service.IUserService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import ru.pyrinoff.somebotexamples.example1.customization.model.CustomUser;

@Primary
@Service
public class CustomUserService extends AbstractUserService<CustomUser> implements IUserService<CustomUser> {

}

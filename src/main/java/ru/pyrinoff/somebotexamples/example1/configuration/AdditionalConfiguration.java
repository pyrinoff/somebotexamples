package ru.pyrinoff.somebotexamples.example1.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@ComponentScan({"ru.pyrinoff.somebotexamples.example1"})
@EnableJpaRepositories("ru.pyrinoff.somebotexamples.example1.repository")
public class AdditionalConfiguration {

}

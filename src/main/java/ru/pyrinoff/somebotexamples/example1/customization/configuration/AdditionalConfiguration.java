package ru.pyrinoff.somebotexamples.example1.customization.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"ru.pyrinoff.somebotexamples.example1"})
public class AdditionalConfiguration {

}

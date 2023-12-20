package ru.pyrinoff.somebotexamples.example2;

import com.github.pyrinoff.somebot.Somebot;

public class Main {

    public static void main(String[] args) {
        final Somebot somebot = Somebot.byClass(Main.class);
        somebot.start();
    }

}

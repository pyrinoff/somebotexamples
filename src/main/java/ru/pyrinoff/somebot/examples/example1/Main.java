package ru.pyrinoff.somebot.examples.example1;

import ru.pyrinoff.somebot.Somebot;

public class Main {

    public static void main(String[] args) {
        final Somebot somebot = Somebot.byClass(Main.class);
        somebot.start();
    }

}
package com.kodilla.patterns.strategy.social;

public class YGeneration extends User {
    String username;

    public YGeneration(String username) {
            super(username);
            socialPublisher = new TwitterPublisher();
    }
}

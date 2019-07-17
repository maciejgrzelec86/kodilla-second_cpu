package com.kodilla.patterns.strategy.social;

public class TwitterPublisher implements SocialPublisher{
    public String share() {
        System.out.println("Twitter");
        String media = "Twitter";
        return media;
    }
}

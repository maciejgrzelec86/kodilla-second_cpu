package com.kodilla.patterns.strategy.social;

public class SnapchatPublisher implements SocialPublisher{
    public String share() {
        System.out.println("Snapchat");
        String media = "Snapchat";
        return media;
    }
}

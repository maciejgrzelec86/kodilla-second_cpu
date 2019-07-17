package com.kodilla.patterns.strategy.social;

import org.junit.Assert;
import org.junit.Test;

public class UserTestSuite {
    @Test
    public void testDefaultSharingStrategies() {
        User milenialUser = new Millenials("milenial user");
        User yGenerationUser = new YGeneration("y user");
        User zGenerationUser = new ZGeneration("z user");

        String milenialTestString = milenialUser.share();
        String yTestString = yGenerationUser.share();
        String zTestString = zGenerationUser.share();

        Assert.assertEquals("Facebook", milenialTestString);
        Assert.assertEquals("Twitter", yTestString);
        Assert.assertEquals("Snapchat", zTestString);
    }

    @Test
    public void testIndividualSharingStrategy(){
        User milenialUser = new Millenials("milenial user");
        milenialUser.setSocialPublisher(new SnapchatPublisher());
        String milenialTestString = milenialUser.share();
        Assert.assertEquals("Snapchat", milenialTestString);
    }
}

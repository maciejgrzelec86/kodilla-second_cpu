package com.kodilla.patterns.builder.bigmac;

import org.junit.Assert;
import org.junit.Test;

public class BigMacTestSuite {
    @Test
    public void testBigMacBuilder(){
        //Given
        BigMac bigMac = new BigMac.BigMacBuilder()
                .roll("Sezam")
                .burger(2)
                .sauce("Standart")
                .ingredients("Onion")
                .ingredients("Bacon")
                .ingredients("Cheasee")
                .build();
        System.out.println(bigMac);
        //When
        int howManyIngredients = bigMac.getIngredients().size();
        int howManyBurger = bigMac.getBurger();
        //Then
        Assert.assertEquals(3, howManyIngredients);
        Assert.assertEquals(2, howManyBurger);
    }
}

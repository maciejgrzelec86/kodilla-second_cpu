package com.kodilla.patterns.builder.bigmac;

import java.util.ArrayList;
import java.util.List;

public final class BigMac {
    private final String roll;
    private final int burger;
    private final String sauce;
    private final List<String> ingredients;

    private BigMac(final String roll, final int burger, final String sauce, final List<String> ingredients) {
        this.roll = roll;
        this.burger = burger;
        this.sauce = sauce;
        this.ingredients = new ArrayList<>(ingredients);
    }

    public static class BigMacBuilder {
        private String roll;
        private int burger;
        private String sauce;
        private List<String> ingredients = new ArrayList<>();

        public BigMacBuilder roll(String roll){
            this.roll = roll;
            return this;
        }

        public BigMacBuilder burger(int burger){
            this.burger = burger;
            return this;
        }

        public BigMacBuilder sauce(String sauce){
            this.sauce = sauce;
            return this;
        }

        public BigMacBuilder ingredients(String ingredient){
            this.ingredients.add(ingredient);
            return this;
        }

        public BigMac build(){
            return new BigMac(roll, burger, sauce, ingredients);
        }
    }

    public String getRoll() {
        return roll;
    }

    public int getBurger() {
        return burger;
    }

    public String getSauce() {
        return sauce;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

}

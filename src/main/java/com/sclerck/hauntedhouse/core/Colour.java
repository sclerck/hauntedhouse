package com.sclerck.hauntedhouse.core;

import java.util.Arrays;

public enum Colour {
    RED("Red"),
    WHITE("White"),
    GREEN("Green"),
    ORANGE("Orange"),
    BLUE("Blue"),
    YELLOW("Yellow"),
    BLACK("Black");

    private final String text;

    Colour(String text) {
        this.text = text;
    }

    public static Colour find(String text) {
        return Arrays.stream(Colour.values()).filter(c -> c.getText().equalsIgnoreCase(text)).findFirst().orElse(null);
    }

    public String getText() {
        return text;
    }

    public String toString() {
        return text;
    }
}

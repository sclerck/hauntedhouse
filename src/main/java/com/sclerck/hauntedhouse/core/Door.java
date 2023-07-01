package com.sclerck.hauntedhouse.core;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Door {

    private boolean locked;

    private Colour colour;

    public void unlock() {
        locked = false;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("The door is ").append(colour).append(" and");
        if (locked) {
            stringBuilder.append(" locked");
        } else {
            stringBuilder.append(" unlocked");
        }

        return stringBuilder.toString();
    }
}

package com.sclerck.hauntedhouse.core;

import lombok.Getter;

@Getter
public class Key {

    private Colour colour;

    private String inscription;

    public Key(Colour colour) {
        this.colour = colour;
    }

    public Key(String inscription) {
        this.inscription = inscription;
    }
}

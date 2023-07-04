package com.sclerck.hauntedhouse.core;

import lombok.Getter;

@Getter
public class Key extends Item {

    public static final String NAME = "Key";

    private Colour colour;

    private String inscription;

    public Key(Colour colour) {
        super(NAME, " a " + colour.getText() + " key", true);
        this.colour = colour;
    }

    public Key(String inscription) {
        super(NAME, " a key inscribed with " + inscription, true);
        this.inscription = inscription;
    }
}

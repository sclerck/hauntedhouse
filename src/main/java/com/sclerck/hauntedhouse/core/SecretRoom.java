package com.sclerck.hauntedhouse.core;

import java.util.Map;
import java.util.function.Function;

public class SecretRoom extends Room {

    private Function<Inventory, Boolean> isVisible;

    public SecretRoom(String name, String description, Floor floor, Door door, Map<String, Object> contents, Function<Inventory, Boolean> isVisible) {
        super(name, description, floor, door, contents);

        this.isVisible = isVisible;
    }

    public SecretRoom(String name, String description, Stairs stairs, Floor floor, Door door, Map<String, Object> contents, Function<Inventory, Boolean> isVisible) {
        super(name, description, stairs, floor, door, contents);

        this.isVisible = isVisible;
    }

    public boolean isVisible(Inventory inventory) {
        return isVisible.apply(inventory);
    }
}

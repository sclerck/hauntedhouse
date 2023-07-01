package com.sclerck.hauntedhouse.core;

import java.util.HashMap;
import java.util.Map;

public class RoomBuilder {

    public static Room build(String name, String description, Floor upFloor, Floor thisFloor, boolean lockedDoor, Colour colour, Map<String, Object> contents) {

        Stairs stairs = null;

        if (upFloor != null) {
            stairs = new Stairs(upFloor, thisFloor);
        }

        if (contents == null) {
            contents = new HashMap<>();
        }

        return new Room(name, description, stairs, thisFloor, new Door(lockedDoor, colour), contents);
    }
}

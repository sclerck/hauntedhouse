package com.sclerck.hauntedhouse.core;

import java.util.HashMap;
import java.util.Map;

public class RoomBuilder {

    public static Room build(String name, String description, Floor upFloor, Floor thisFloor, boolean lockedDoor, Colour colour, Map<String, Object> contents) {

        return new Room(name, description, new Stairs(upFloor, thisFloor), thisFloor, new Door(lockedDoor, colour), contents);
    }

    public static Room build(String name, String description, Floor thisFloor, boolean lockedDoor, Colour colour, Map<String, Object> contents) {

        return new Room(name, description, thisFloor, new Door(lockedDoor, colour), contents);
    }

    public static Room build(String name, String description, Floor upFloor, Floor thisFloor, boolean lockedDoor, Colour colour) {

        return new Room(name, description, new Stairs(upFloor, thisFloor), thisFloor, new Door(lockedDoor, colour), new HashMap<>());
    }

    public static Room build(String name, String description, Floor thisFloor, boolean lockedDoor, Colour colour) {

        return new Room(name, description, thisFloor, new Door(lockedDoor, colour), new HashMap<>());
    }


}

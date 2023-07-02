package com.sclerck.hauntedhouse.core;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class SecretRoomBuilder {

    public static SecretRoom build(String name, String description, Floor upFloor, Floor thisFloor, boolean lockedDoor, Colour colour, Map<String, Object> contents, Function<Inventory, Boolean> isVisible) {

        return new SecretRoom(name, description, new Stairs(upFloor, thisFloor), thisFloor, new Door(lockedDoor, colour), contents, isVisible);
    }

    public static SecretRoom build(String name, String description, Floor thisFloor, boolean lockedDoor, Colour colour, Map<String, Object> contents, Function<Inventory, Boolean> isVisible) {

        return new SecretRoom(name, description, thisFloor, new Door(lockedDoor, colour), contents, isVisible);
    }

    public static SecretRoom build(String name, String description, Floor upFloor, Floor thisFloor, boolean lockedDoor, Colour colour, Function<Inventory, Boolean> isVisible) {

        return new SecretRoom(name, description, new Stairs(upFloor, thisFloor), thisFloor, new Door(lockedDoor, colour), new HashMap<>(), isVisible);
    }

    public static SecretRoom build(String name, String description, Floor thisFloor, boolean lockedDoor, Colour colour, Function<Inventory, Boolean> isVisible) {

        return new SecretRoom(name, description, thisFloor, new Door(lockedDoor, colour), new HashMap<>(), isVisible);
    }


}

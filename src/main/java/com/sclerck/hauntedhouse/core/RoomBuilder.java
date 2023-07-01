package com.sclerck.hauntedhouse.core;

public class RoomBuilder {

    public static Room build(String name, String description, Floor upFloor, Floor thisFloor, boolean lockedDoor, Colour colour) {

        Stairs stairs = new Stairs(upFloor, thisFloor);

        return new Room(name, description, stairs, thisFloor, new Door(lockedDoor, colour));
    }

    public static Room build(String name, String description, Floor thisFloor, boolean lockedDoor, Colour colour) {

        return new Room(name, description, null, thisFloor, new Door(lockedDoor, colour));
    }
}

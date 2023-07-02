package com.sclerck.hauntedhouse.core;

import lombok.Getter;

import java.util.Map;

@Getter
public class Room extends Location {

    private String name;

    private String description;

    private Stairs stairs;

    private Floor floor;

    private Door door;

    protected Room(String name, String description, Stairs stairs, Floor floor, Door door, Map<String, Object> contents) {
        super(contents);
        this.name = name;
        this.description = description;
        this.stairs = stairs;
        this.floor = floor;
        this.door = door;
    }

    protected Room(String name, String description, Floor floor, Door door, Map<String, Object> contents) {
        super(contents);
        this.name = name;
        this.description = description;
        this.floor = floor;
        this.door = door;
        stairs = null;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("You are in the ").append(name).append(" room on floor ").append(floor.getNumber());
        stringBuilder.append(". ").append(description);

        if (stairs != null) {
            stringBuilder.append(" There are stairs going up to floor ").append(stairs.getTopFloor().getNumber()).append(". ");
        }

        if (getContents() == null || getContents().isEmpty()) {
            stringBuilder.append("There is nothing else of note.");
        } else {
            stringBuilder.append("There is also");
            getContents().keySet().forEach(k -> stringBuilder.append(" a ").append(k).append(","));
        }

        return stringBuilder.toString();
    }

}

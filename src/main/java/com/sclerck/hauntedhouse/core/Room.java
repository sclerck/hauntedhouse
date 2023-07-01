package com.sclerck.hauntedhouse.core;

import lombok.Getter;

@Getter
public class Room extends Location {

    private String name;

    private String description;

    private Stairs stairs;

    private Floor floor;

    private Door door;

    protected Room(String name, String description, Stairs stairs, Floor floor, Door door) {
        this.name = name;
        this.description = description;
        this.stairs = stairs;
        this.floor = floor;
        this.door = door;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("You are in the ").append(name).append(" room on floor ").append(floor.getNumber());
        stringBuilder.append(". ").append(description);
        stringBuilder.append(" There are stairs going up to floor ").append(stairs.getTopFloor().getNumber()).append(". ");
        if (getContents() == null || getContents().isEmpty()) {
            stringBuilder.append("There is nothing else of note.");
        } else {
            stringBuilder.append("There is also");
            getContents().keySet().forEach(k -> stringBuilder.append(" a ").append(k).append(","));
        }

        return stringBuilder.toString();
    }

}

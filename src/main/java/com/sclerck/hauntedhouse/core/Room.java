package com.sclerck.hauntedhouse.core;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Map;

@AllArgsConstructor
@Getter
public class Room extends Location {

    private String name;

    private Stairs stairs;

    private Floor floor;

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("You are in the ").append(name).append(" room on floor ").append(floor.getNumber());
        if (getContents() == null || getContents().isEmpty()) {
            stringBuilder.append(" There is nothing else of note.");
        } else {
            stringBuilder.append(" There is also");
            getContents().keySet().forEach(k -> stringBuilder.append(" a ").append(k).append(","));
        }

        return stringBuilder.toString();
    }

}

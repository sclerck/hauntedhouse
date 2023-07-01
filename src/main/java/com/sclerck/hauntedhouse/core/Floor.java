package com.sclerck.hauntedhouse.core;

import lombok.Getter;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

@Getter
public class Floor extends Location {

    private int number;

    private List<Room> rooms;

    public Floor(int number) {
        super(new HashMap<>());
        this.number = number;
        this.rooms = new LinkedList<>();
    }

    public void addRoom(Room room) {
        this.rooms.add(room);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("You are on floor ").append(number)
                .append(". There are ").append(rooms.size()).append(" rooms. ");

        if (rooms.size() > 0) {
            stringBuilder.append("The doors to the rooms are ");
            rooms.forEach(r -> stringBuilder.append(r.getDoor().getColour().getText()).append(", "));
        }

        if (getContents() == null || getContents().isEmpty()) {
            stringBuilder.append(" There is nothing else of note.");
        } else {
            stringBuilder.append(" There is also");
            getContents().keySet().forEach(k -> stringBuilder.append(" a ").append(k).append(","));
        }

        return stringBuilder.toString();
    }

}

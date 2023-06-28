package com.sclerck.hauntedhouse.core;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class Floor extends Location {

    private List<Door> doors;

    private int number;

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("You are on floor ").append(number)
                .append(". There are ").append(doors.size()).append(" doors. ");

        if (doors.size() > 0) {
            stringBuilder.append("The doors are ");
            doors.forEach(d -> stringBuilder.append(d.getColour().getText()).append(", "));
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

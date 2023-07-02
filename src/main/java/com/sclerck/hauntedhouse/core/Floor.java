package com.sclerck.hauntedhouse.core;

import com.sclerck.hauntedhouse.game.HauntedHouseService;
import lombok.Getter;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public class Floor extends Location {

    private int number;

    private List<Room> rooms;

    private List<SecretRoom> secretRooms;

    private HauntedHouseService service;

    public Floor(int number, HauntedHouseService service) {
        super(new HashMap<>());
        this.number = number;
        this.service = service;
        this.rooms = new LinkedList<>();
        this.secretRooms = new LinkedList<>();
    }

    public void addRoom(Room room) {
        this.rooms.add(room);
    }

    public void addSecretRoom(SecretRoom secretRoom) { this.secretRooms.add(secretRoom); }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("You are on floor ").append(number)
                .append(". There are ").append(rooms.size()).append(" rooms. ");

        if (rooms.size() > 0) {
            stringBuilder.append("The doors to the rooms are ");
            rooms.forEach(r -> stringBuilder.append(r.getDoor().getColour().getText()).append(", "));
        }

        if (secretRooms.size() > 0) {
            List<SecretRoom> visibleSecretRooms = secretRooms.stream().filter(s -> s.isVisible(service.getInventory())).collect(Collectors.toList());

            if (visibleSecretRooms.size() > 0) {
                stringBuilder.append("Secret rooms are ");
                visibleSecretRooms.forEach(r -> stringBuilder.append(r.getDoor().getColour().getText()).append(", "));
            }
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

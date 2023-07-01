package com.sclerck.hauntedhouse.game;

import com.sclerck.hauntedhouse.core.Colour;
import com.sclerck.hauntedhouse.core.Door;
import com.sclerck.hauntedhouse.core.Floor;
import com.sclerck.hauntedhouse.core.Inventory;
import com.sclerck.hauntedhouse.core.Key;
import com.sclerck.hauntedhouse.core.Location;
import com.sclerck.hauntedhouse.core.Room;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class HauntedHouseService {

    private House house;
    private Inventory inventory;
    private Location currentLocation;

    private boolean started;

    public HauntedHouseService() {
        currentLocation = null;

        started = false;
    }

    public void init() {
        house = new House();
        house.setup();

        inventory = new Inventory();

        System.out.println("Welcome to the Haunted House! Type \"start\" to start the game!");
    }

    public void action(String text) {
        if (text.equals("start")) {
            start();
        }

        if (text.startsWith("get")) {
            get(text);
        }

        if (text.startsWith("unlock")) {
            unlock(text);
        }

        if (text.equalsIgnoreCase("look")) {
            System.out.println(currentLocation);
        }

        if (text.equalsIgnoreCase("inventory")) {
            System.out.println(inventory);
        }
    }

    private void start() {
        if (started) {
            System.out.println("You've already started!");
            return;
        }

        currentLocation = house.getStartingFloor();

        System.out.println(currentLocation);

        started = true;
    }

    private void get(String text) {
        String item = text.split(" ")[1];

        Object floorItem = currentLocation.getContents().get(item);
        if (floorItem == null) {
            System.out.println("No such item is available.");
        } else {
            if (floorItem instanceof Key) {
                inventory.addKey((Key) floorItem);
            } else {
                inventory.add(item, floorItem);
            }
            System.out.println("You picked up the " + item);
            currentLocation.getContents().remove(item);
        }
    }

    private void unlock(String text) {
        String[] input = text.split(" ");

        Colour colour = Colour.find(input[1]);

        if (colour == null) {
            System.out.println("No such colour!");
        } else {
            Floor floor = (Floor) currentLocation;
            Room room = floor.getRooms().stream().filter(r -> r.getDoor().getColour().equals(colour)).findFirst().orElse(null);

            if (room == null) {
                System.out.println("No room has a door of that colour!");
            } else {
                Key key = inventory.getKey(colour);

                if (key == null) {
                    System.out.println("You do not have a key of that colour!");
                } else if (!room.getDoor().isLocked()) {
                    System.out.println("The door is already unlocked.");
                } else {
                    room.getDoor().unlock();
                    System.out.println("The " + colour.getText() + " door is unlocked and you enter the " + room.getName() + " room.");
                    currentLocation = room;
                }
            }
        }
    }
}

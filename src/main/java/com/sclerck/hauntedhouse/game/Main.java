package com.sclerck.hauntedhouse.game;

import com.sclerck.hauntedhouse.core.Colour;
import com.sclerck.hauntedhouse.core.Door;
import com.sclerck.hauntedhouse.core.Floor;
import com.sclerck.hauntedhouse.core.Inventory;
import com.sclerck.hauntedhouse.core.Key;
import com.sclerck.hauntedhouse.core.Location;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        House house = new House();

        house.setup();

        Inventory inventory = new Inventory();

        System.out.println("Welcome to the Haunted House! Type \"start\" to start the game!");

        Scanner in = new Scanner(System.in);

        Location currentLocation = null;

        while(true) {
            String input = in.nextLine();

            if (input.equals("start")) {
                currentLocation = house.getStartingFloor();

                System.out.println(currentLocation);
            }

            if (input.startsWith("get")) {
                String item = input.split(" ")[1];

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

            if (input.startsWith("unlock")) {
                String[] text = input.split(" ");

                Colour colour = Colour.find(text[1]);

                if (colour == null) {
                    System.out.println("No such colour!");
                } else {
                    Floor floor = (Floor) currentLocation;
                    Door door = floor.getDoors().stream().filter(d -> d.getColour().equals(colour)).findFirst().orElse(null);

                    if (door == null) {
                        System.out.println("No door of that colour!");
                    } else {
                        Key key = inventory.getKey(colour);

                        if (key == null) {
                            System.out.println("You do not have a key of that colour!");
                        } else if (!door.isLocked()) {
                            System.out.println("The door is already unlocked.");
                        } else {
                            door.unlock();
                            System.out.println("The " + colour.getText() + " door is unlocked and you enter the " + door.getRoom().getName() + " room.");
                            currentLocation = door.getRoom();
                        }
                    }
                }
            }

            if (input.equalsIgnoreCase("look")) {
                System.out.println(currentLocation);
            }

            if (input.equalsIgnoreCase("inventory")) {
                System.out.println(inventory);
            }
        }
    }
}

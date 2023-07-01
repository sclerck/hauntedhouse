package com.sclerck.hauntedhouse.game;

import com.sclerck.hauntedhouse.core.Colour;
import com.sclerck.hauntedhouse.core.Door;
import com.sclerck.hauntedhouse.core.Floor;
import com.sclerck.hauntedhouse.core.Key;
import com.sclerck.hauntedhouse.core.Room;
import com.sclerck.hauntedhouse.core.RoomBuilder;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public class House {

    private Floor startingFloor;

    public void setup() {

        // Floor 0 is the entrance. Simple tutorial with one key and one locked door
        Floor floor0 = new Floor(0);
        floor0.getContents().put("key", new Key(Colour.WHITE));

        // Floor 1 has 3 rooms and a secret basement
        // TODO add the basement
        Floor floor1 = new Floor(1);

        // Floor 2 has 5 rooms
        Floor floor2 = new Floor(2);

        // Floor 3 has 7 rooms
        Floor floor3 = new Floor(3);

        Room entrance = RoomBuilder.build("entrance", "This is the entrance hall.", floor1, floor0, true, Colour.WHITE, null);
        floor0.addRoom(entrance);

        Room open = RoomBuilder.build("white room", "This is the white room.", null, floor1, false, Colour.WHITE, new HashMap<>(Map.of("key", new Key(Colour.RED))));
        Room red = RoomBuilder.build("red room", "This is the red room.", null, floor1, true, Colour.RED, new HashMap<>(Map.of("key", new Key(Colour.GREEN))));
        Room green = RoomBuilder.build("green room", "This is the green room.", floor2, floor1, true, Colour.GREEN, null);

        floor1.addRoom(open);
        floor1.addRoom(red);
        floor1.addRoom(green);

        startingFloor = floor0;
    }
}

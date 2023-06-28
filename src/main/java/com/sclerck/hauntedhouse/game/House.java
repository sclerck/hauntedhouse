package com.sclerck.hauntedhouse.game;

import com.sclerck.hauntedhouse.core.Colour;
import com.sclerck.hauntedhouse.core.Door;
import com.sclerck.hauntedhouse.core.Floor;
import com.sclerck.hauntedhouse.core.Key;
import com.sclerck.hauntedhouse.core.Room;
import com.sclerck.hauntedhouse.core.Stairs;
import lombok.Getter;

import java.util.List;
import java.util.Map;

@Getter
public class House {

    private Floor startingFloor;

    public void setup() {

        // Floor 0 is the entrance. Simple tutorial with one key and one locked door
        Key key = new Key(Colour.WHITE);
        Stairs stairs = null;
        Floor floor0 = null;
        Room entrance = new Room("entrance", stairs, floor0);
        Door door = new Door(entrance, true, key, Colour.WHITE);
        floor0 = new Floor(List.of(door), 0);
        floor0.getContents().put("key", key);

        startingFloor = floor0;

        // Floor 1 has 3 doors
        Floor floor1 = null;

        stairs = new Stairs(floor1, floor0);
    }
}

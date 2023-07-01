package com.sclerck.hauntedhouse.game;

import com.sclerck.hauntedhouse.core.Colour;
import com.sclerck.hauntedhouse.core.Door;
import com.sclerck.hauntedhouse.core.Floor;
import com.sclerck.hauntedhouse.core.Key;
import com.sclerck.hauntedhouse.core.Room;
import com.sclerck.hauntedhouse.core.RoomBuilder;
import lombok.Getter;

@Getter
public class House {

    private Floor startingFloor;

    public void setup() {

        // Floor 0 is the entrance. Simple tutorial with one key and one locked door
        Floor floor0 = new Floor(0);

        // Floor 1 has 3 rooms
        Floor floor1 = new Floor(1);

        Key key = new Key(Colour.WHITE);
        Room entrance = RoomBuilder.build("entrance", "This is the entrance hall.", floor1, floor0, true, Colour.WHITE);
        floor0.addRoom(entrance);
        floor0.getContents().put("key", key);

        startingFloor = floor0;
    }
}

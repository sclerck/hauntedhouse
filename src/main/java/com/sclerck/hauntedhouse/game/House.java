package com.sclerck.hauntedhouse.game;

import com.sclerck.hauntedhouse.core.BreakerBox;
import com.sclerck.hauntedhouse.core.Colour;
import com.sclerck.hauntedhouse.core.Door;
import com.sclerck.hauntedhouse.core.Floor;
import com.sclerck.hauntedhouse.core.Hammer;
import com.sclerck.hauntedhouse.core.Inventory;
import com.sclerck.hauntedhouse.core.Item;
import com.sclerck.hauntedhouse.core.Key;
import com.sclerck.hauntedhouse.core.Room;
import com.sclerck.hauntedhouse.core.RoomBuilder;
import com.sclerck.hauntedhouse.core.SecretRoom;
import com.sclerck.hauntedhouse.core.SecretRoomBuilder;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Getter
public class House {

    private Floor startingFloor;

    public void setup(HauntedHouseService service) {

        // Floor 0 is the entrance. Simple tutorial with one key and one locked door
        Floor floor0 = new Floor(0, service);
        floor0.getContents().put(Key.NAME, new Key(Colour.WHITE));

        // Floor 1 has 3 rooms and a secret basement
        Floor floor1 = new Floor(1, service);

        // Floor 2 has 5 rooms
        Floor floor2 = new Floor(2, service);

        // Floor 3 has 7 rooms
        Floor floor3 = new Floor(3, service);

        // Floor 0 rooms
        Room entrance = RoomBuilder.build("entrance", "This is the entrance hall.", floor1, floor0, true, Colour.WHITE);
        floor0.addRoom(entrance);

        // Floor 1 rooms
        Room open = RoomBuilder.build("white room", "This is the white room.", floor1, false, Colour.WHITE, new HashMap<>(Map.of(Key.NAME, new Key(Colour.RED))));
        Room red = RoomBuilder.build("red room", "This is the red room.", floor1, true, Colour.RED, new HashMap<>(Map.of(Key.NAME, new Key(Colour.GREEN))));
        Room green = RoomBuilder.build("green room", "This is the green room.", floor2, floor1, true, Colour.GREEN);

        floor1.addRoom(open);
        floor1.addRoom(red);
        floor1.addRoom(green);

        Map<String, Item> basementItems = new HashMap<>();
        basementItems.put(Key.NAME, new Key(Colour.YELLOW));
        Hammer hammer = new Hammer();
        basementItems.put(hammer.getName(), hammer);
        BreakerBox breakerBox = new BreakerBox();
        basementItems.put(breakerBox.getName(), breakerBox);
        SecretRoom basement = SecretRoomBuilder.build("basement", "This is the basement.", floor1, true, Colour.BLACK, basementItems, inventory -> inventory.getKey("basement") != null);

        floor1.addSecretRoom(basement);

        startingFloor = floor0;
    }
}

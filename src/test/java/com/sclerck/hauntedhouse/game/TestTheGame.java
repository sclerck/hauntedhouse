package com.sclerck.hauntedhouse.game;

import com.sclerck.hauntedhouse.core.Floor;
import com.sclerck.hauntedhouse.game.HauntedHouseService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class TestTheGame {

    @Test
    public void testTheWholeGame() {
        HauntedHouseService service = new HauntedHouseService();
        service.init();

        service.action("start");

        // floor 0
        service.action("get Key");
        service.action("unlock white door");
        service.action("enter white door");
        service.action("climb");
        // floor 1
        service.action("look");
        service.action("enter white door");
        service.action("get Key");
        service.action("exit");
        service.action("unlock red door");
        service.action("enter red door");
        service.action("get Key");
        service.action("exit");
        service.action("unlock green door");
        service.action("enter green door");
        service.action("climb");
        // floor 2
        service.action("look");
        service.action("inventory");

        assertEquals(2, ((Floor)service.getCurrentLocation()).getNumber());
    }
}

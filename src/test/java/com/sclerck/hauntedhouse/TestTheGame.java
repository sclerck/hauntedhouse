package com.sclerck.hauntedhouse;

import com.sclerck.hauntedhouse.game.HauntedHouseService;
import org.junit.jupiter.api.Test;

public class TestTheGame {

    @Test
    public void testTheWholeGame() {
        HauntedHouseService service = new HauntedHouseService();
        service.init();

        service.action("start");
        service.action("get key");
        service.action("unlock white door");
        service.action("look");
    }

}

package com.sclerck.hauntedhouse.game;

import com.sclerck.hauntedhouse.core.Inventory;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        HauntedHouseService service = new HauntedHouseService();
        service.init();

        while(true) {
            String input = in.nextLine();

            service.action(input);
        }
    }
}

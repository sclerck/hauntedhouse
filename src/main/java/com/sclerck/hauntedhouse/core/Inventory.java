package com.sclerck.hauntedhouse.core;

import java.util.HashMap;
import java.util.Map;

public class Inventory {

    private Map<String, Object> items = new HashMap<>();

    private Map<Colour, Key> keyChain = new HashMap<>();


    public Object get(String name) {
        return items.get(name);
    }

    public void add(String name, Object object) {
        items.put(name, object);
    }

    public Key getKey(Colour colour) {
        return keyChain.get(colour);
    }

    public void addKey(Key key) {
        keyChain.put(key.getColour(), key);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("You have these items: ").append(items.keySet())
                .append(" and these keys: ").append(keyChain.keySet());

        return stringBuilder.toString();
    }
}

package com.sclerck.hauntedhouse.core;

import java.util.HashMap;
import java.util.Map;

public class Inventory {

    private Map<String, Item> items = new HashMap<>();

    private Map<Object, Key> keyChain = new HashMap<>();

    public void add(String name, Item item) {
        if (item instanceof Key) {
            addKey((Key)item);
        } else {
            items.put(name, item);
        }
    }

    public Key getKey(Colour colour) {
        return keyChain.get(colour);
    }

    public Key getKey(String inscription) { return keyChain.get(inscription); }

    private void addKey(Key key) {

        if (key.getInscription() == null) {
            keyChain.put(key.getColour(), key);
        } else {
            keyChain.put(key.getInscription(), key);
        }
    }

    public Object get(String name) {
        return items.get(name);
    }

    public void remove(String name) {
        items.remove(name);
    }

    public void removeKey(Key key) {
        if (key.getInscription() == null) {
            keyChain.remove(key.getColour(), key);
        } else {
            keyChain.remove(key.getInscription(), key);
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("You have these items: ").append(items.keySet())
                .append(" and these keys: ").append(keyChain.keySet());

        return stringBuilder.toString();
    }
}

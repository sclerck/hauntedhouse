package com.sclerck.hauntedhouse.core;

import java.util.HashMap;
import java.util.Map;

public class Inventory {

    private Map<String, Object> items = new HashMap<>();

    private Map<Object, Key> keyChain = new HashMap<>();

    public Object get(String name) {
        return items.get(name);
    }

    public void add(String name, Object object) {
        items.put(name, object);
    }

    public Key getKey(Colour colour) {
        return keyChain.get(colour);
    }

    public Key getKey(String inscription) { return keyChain.get(inscription); }

    public void addKey(Key key) {

        if (key.getInscription() == null) {
            keyChain.put(key.getColour(), key);
        } else {
            keyChain.put(key.getInscription(), key);
        }
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

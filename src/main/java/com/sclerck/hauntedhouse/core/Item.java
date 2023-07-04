package com.sclerck.hauntedhouse.core;

public abstract class Item {

    private boolean canBeCarried;
    private String name;
    private String description;

    protected Item(String name, String description, boolean canBeCarried) {
        this.canBeCarried = canBeCarried;
        this.name = name;
        this.description = description;
    }

    public boolean canBeCarried() {
        return canBeCarried;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("A ").append(name).append(" that looks like ").append(description);
        return stringBuilder.toString();
    }
}

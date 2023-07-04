package com.sclerck.hauntedhouse.core;


import lombok.Getter;

import java.util.Map;

@Getter
public abstract class Location {

    private Map<String, Item> contents;

    public Location(Map<String, Item> contents) {
        this.contents = contents;
    }
}

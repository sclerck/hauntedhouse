package com.sclerck.hauntedhouse.core;


import lombok.Getter;

import java.util.Map;

@Getter
public abstract class Location {

    private Map<String, Object> contents;

    public Location(Map<String, Object> contents) {
        this.contents = contents;
    }
}

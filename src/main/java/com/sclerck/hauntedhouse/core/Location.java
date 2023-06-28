package com.sclerck.hauntedhouse.core;


import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public abstract class Location {

    private Map<String, Object> contents = new HashMap<>();
}

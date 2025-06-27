package com.venned.simplemines.api;


import java.util.Map;

public interface MineAPI {
    Map<String, IMine> getMines();

    IMine getMine(String name);

    boolean resetMine(String name);

    long getRemainingTime(String name);
}
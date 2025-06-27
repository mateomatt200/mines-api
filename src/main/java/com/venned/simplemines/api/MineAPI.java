package com.venned.simplemines.api;


import org.bukkit.Location;

import java.util.Map;

public interface MineAPI {
    Map<String, IMine> getMines();

    IMine getMine(String name);

    String getMineNameAt(Location loc);

    boolean resetMine(String name);

    long getRemainingTime(String name);
}
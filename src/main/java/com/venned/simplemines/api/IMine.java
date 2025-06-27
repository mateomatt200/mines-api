package com.venned.simplemines.api;

import org.bukkit.Location;

public interface IMine {
    String getName();
    boolean isInside(Location location);
    void reset();
    long getRemainingTime();
}
package com.venned.simplemines.api;

import com.venned.simplemines.build.Mine;
import com.venned.simplemines.manager.MineManager;
import org.bukkit.Location;
import org.jetbrains.annotations.Nullable;

public final class SimpleMinesAPI {

    private SimpleMinesAPI() {}

    /**
     * Obtiene el MineManager principal.
     */
    public static MineManager getMineManager() {
        return com.venned.simplemines.Main.getPlugin().getMineManager();
    }

    /**
     * Recupera una mina por su nombre.
     * @param name el identificador de la mina
     * @return la instancia Mine, o null si no existe
     */
    @Nullable
    public static Mine getMine(String name) {
        return getMineManager().getMine(name);
    }

    /**
     * Verifica si una ubicación pertenece a alguna mina.
     * @param loc ubicación a comprobar
     * @return el nombre de la mina contenedora, o null si no está en ninguna
     */
    @Nullable
    public static String getMineNameAt(Location loc) {
        for (Mine m : getMineManager().getMines().values()) {
            if (m.isInside(loc)) return m.getMineName();
        }
        return null;
    }

    /**
     * Forza el reset de la mina indicada.
     * @param name nombre de la mina a resetear
     * @return true si existía y se reseteó, false si no existe
     */
    public static boolean resetMine(String name) {
        Mine m = getMine(name);
        if (m == null) return false;
        m.reset();
        return true;
    }

    /**
     * Obtiene el tiempo restante (en segundos) hasta el próximo reset por timer.
     * @param name nombre de la mina
     * @return segundos restantes, o -1 si no usa timer / no existe
     */
    public static long getRemainingTime(String name) {
        Mine m = getMine(name);
        if (m == null || !m.useTimer) return -1;
        long elapsed = (System.currentTimeMillis()/1000) - m.lastReset.getEpochSecond();
        long left = m.timer - elapsed;
        return Math.max(0, left);
    }
}
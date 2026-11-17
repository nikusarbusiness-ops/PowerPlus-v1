package de.power;

import net.luckperms.api.LuckPerms;
import net.luckperms.api.LuckPermsProvider;
import org.bukkit.entity.Player;

/** Wird nur geladen, wenn LuckPerms installiert ist. */
public class LuckPermsHook {

    private final LuckPerms api = LuckPermsProvider.get();

    /** Liest die LuckPerms-Meta "power.homes" (Zahl) oder null. */
    public Integer homesMeta(Player p) {
        try {
            String v = api.getPlayerAdapter(Player.class).getMetaData(p).getMetaValue("power.homes");
            return v == null ? null : Integer.parseInt(v.trim());
        } catch (Exception e) {
            return null;
        }
    }
}

package io.github.mcagi.mobs;

import org.bukkit.plugin.java.JavaPlugin;

public final class Mobs extends JavaPlugin {
    @Override
    public void onEnable() {
        getLogger().info("MCAGI-Mobs plugin enabled");
    }

    @Override
    public void onDisable() {
        getLogger().info("MCAGI-Mobs plugin disabled");
    }
}

package chuva.hg;

import org.bukkit.plugin.java.JavaPlugin;

public final class Hg extends JavaPlugin {

    private static Hg instance;

    @Override
    public void onEnable() {
        instance = this;
    }

    @Override
    public void onDisable() {
    }

    public static Hg getInstance() {
        return instance;
    }
}

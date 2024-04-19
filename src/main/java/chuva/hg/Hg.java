package chuva.hg;

import chuva.hg.state.StateManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class Hg extends JavaPlugin {

    private static Hg instance;

    @Override
    public void onEnable() {
        instance = this;

        StateManager.start();
    }

    @Override
    public void onDisable() {
    }

    public static Hg getInstance() {
        return instance;
    }
}

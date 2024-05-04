package chuva.hg;

import chuva.hg.events.General;
import chuva.hg.events.StatesEvents;
import chuva.hg.player.PlayerManager;
import chuva.hg.state.StateManager;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class Hg extends JavaPlugin {

    private static Hg instance;

    @Override
    public void onEnable() {
        instance = this;
        getConfig().options().copyDefaults(true);
        saveConfig();
        events();

        PlayerManager.loadData();
        StateManager.start();
    }

    @Override
    public void onDisable() {
        PlayerManager.saveData();
    }

    public static Hg getInstance() {
        return instance;
    }
    void events() {
        getServer().getPluginManager().registerEvents(new General(), this);
        getServer().getPluginManager().registerEvents(new StatesEvents(), this);
    }
}

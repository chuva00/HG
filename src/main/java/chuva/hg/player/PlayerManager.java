package chuva.hg.player;

import chuva.hg.Hg;
import chuva.hg.entities.EntityEconomy;
import chuva.hg.entities.EntityPlayer;
import chuva.hg.entities.EntityStatus;
import chuva.hg.groups.Groups;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import java.awt.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PlayerManager {

    static private FileConfiguration config;

    public static Map<String, EntityPlayer> mapPlayers = new HashMap<>();

    public static void loadData(){
        config = Hg.getInstance().getConfig();

        String name;
        Groups group;
        int kills, deaths, wins, loses, mmr, points, cash;

        EntityStatus status;
        EntityEconomy economy;
        EntityPlayer entityPlayer;

        for (String players : config.getConfigurationSection("").getKeys(false)) {
            if (!config.contains("")) return;

            name = players;
            group = Groups.valueOf(config.getString(players + ".group"));
            kills = config.getInt(players + ".status.kill");
            deaths = config.getInt(players + ".status.death");
            wins = config.getInt(players + ".status.wins");
            loses = config.getInt(players + ".status.loses");
            mmr = config.getInt(players + ".status.mmr");
            points = config.getInt(players + ".economy.points");
            cash = config.getInt(players + ".economy.cash");

            status = new EntityStatus(kills, deaths, wins, loses, mmr);
            economy = new EntityEconomy(points, cash);
            entityPlayer = new EntityPlayer(group, economy, Collections.emptyList(), status);

            mapPlayers.put(name, entityPlayer);

            //KITS SOON
        }
    }
    public static void saveData(){
        config = Hg.getInstance().getConfig();

        EntityPlayer entityPlayer;

        if (mapPlayers.isEmpty()) return;
        for (String players : mapPlayers.keySet()) {
            entityPlayer = mapPlayers.get(players);

            config.set(players + ".group", entityPlayer.getGroup().toString());
            config.set(players + ".status.kill", entityPlayer.getStatus().getKills());
            config.set(players + ".status.death", entityPlayer.getStatus().getDeaths());
            config.set(players + ".status.wins", entityPlayer.getStatus().getWins());
            config.set(players + ".status.loses", entityPlayer.getStatus().getLoses());
            config.set(players + ".status.mmr", entityPlayer.getStatus().getMmr());
            config.set(players + ".economy.points", entityPlayer.getEconomy().getPoints());
            config.set(players + ".economy.cash", entityPlayer.getEconomy().getCash());
        }
    }

    public static void verify(Player player) {
        if (!mapPlayers.containsKey(player.getName())) {
            mapPlayers.put(player.getName(), new EntityPlayer(Groups.DEFAULT,
                    new EntityEconomy(0, 0), Collections.emptyList(), new EntityStatus(0, 0, 0, 0, 0)));
        }
    }
    public static EntityPlayer get(String name) {
        return mapPlayers.get(name);
    }
    public static EntityPlayer get(Player player) {
        return mapPlayers.get(player.getName());
    }
}

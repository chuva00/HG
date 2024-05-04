package chuva.hg.events;

import chuva.hg.player.PlayerManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class General implements Listener {

    @EventHandler
    void join(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        PlayerManager.verify(player);

        event.setJoinMessage(null);
    }
    @EventHandler
    void leave(PlayerQuitEvent event) {
        Player player = event.getPlayer();

        event.setQuitMessage(null);
    }
    @EventHandler
    void chat(AsyncPlayerChatEvent event) {
        Player player = event.getPlayer();

        String prefix = "["+PlayerManager.get(player).getGroup().getColor()+""+PlayerManager.get(player).getGroup().getDisplayName()+"] ";
        event.setFormat(prefix + player.getName() + " > " + event.getMessage());
    }
}

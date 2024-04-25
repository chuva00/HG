package chuva.hg.events;

import chuva.hg.state.State;
import chuva.hg.state.StateManager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class StatesEvents implements Listener {

    @EventHandler
    void blockBreak(BlockBreakEvent event) {
        if (StateManager.getState().equals(State.STARTING)) {
            event.setCancelled(true);
        }
    }
    @EventHandler
    void blockPlace(BlockPlaceEvent event) {
        if (StateManager.getState().equals(State.STARTING)) {
            event.setCancelled(true);
        }
    }
    @EventHandler
    void blockBreak(AsyncPlayerChatEvent event) {
        if (StateManager.getState().equals(State.STARTING)) {
            event.setCancelled(true);
        }
    }

}

package chuva.hg.state;

import chuva.hg.Hg;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class StateManager  {

    private static State state;
    private static int i;

    public static void start() {
        i = 0;
        setState(State.STARTING);
        Bukkit.getScheduler().scheduleSyncRepeatingTask(Hg.getInstance(), () -> {
            i++;
            switch (getState()) {
                case GAME:

                    break;
                case STARTING:
                    if (i == getState().getTiming()) {
                        i = 0;
                        if (Bukkit.getOnlinePlayers().size() < 5) {
                            Bukkit.getOnlinePlayers().forEach(player -> player.sendMessage("Contagem iniciando novamente por jogadores insuficientes!"));
                        } else {
                            Bukkit.getOnlinePlayers().forEach(player -> player.sendMessage("Invulnerabilidade comecando!"));
                            setState(State.INVULNERABILITY);
                        }
                    }
                    break;
                case INVULNERABILITY:
                    break;
            }
        }, 0L, 20L);
    }

    public static State getState() {
        return state;
    }

    public static void setState(State state) {
        StateManager.state = state;
    }
}

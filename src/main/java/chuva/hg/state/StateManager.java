package chuva.hg.state;

import chuva.hg.Hg;
import org.bukkit.Bukkit;
import org.bukkit.Sound;

public class StateManager  {

    private static State state;
    private static int i;

    private static String getMinutesFromString(int seconds) {
        int sec = 0;
        int min = 0;
        if (seconds >= 60) {
            min = seconds / 60;
            sec = seconds % 60;
        } else {
            sec = seconds;
        }
        if (min != 0) {
            return min + " minutos e " + sec + " segundos!";
        } else return sec + " segundos!";
    }

    public static void start() {
        i = 0;
        setState(State.STARTING);
        Bukkit.getScheduler().scheduleSyncRepeatingTask(Hg.getInstance(), () -> {
            i++;
            int restTime = getState().getTiming() - i;
            if (restTime % 30 == 0 && getState().equals(State.STARTING)) {
                Bukkit.getOnlinePlayers().forEach(player->player.sendMessage("Jogo comecando em " + getMinutesFromString(restTime)));
            } else if (restTime % 15 == 0 && getState().equals(State.INVULNERABILITY)) {
                Bukkit.getOnlinePlayers().forEach(player->player.sendMessage("Invulnerabilidade acaba em " + getMinutesFromString(restTime)));
            }
            if (i == getState().getTiming()) {
                switch (getState()) {
                    case GAME:
                        //MINIFEAST
                        //FINAL ARENA
                        break;
                    case STARTING:
                        i = 0;
                        if (Bukkit.getOnlinePlayers().size() < 5) {
                            Bukkit.getOnlinePlayers().forEach(player -> player.sendMessage("Contagem iniciando novamente por jogadores insuficientes!"));
                        } else {
                            Bukkit.getOnlinePlayers().forEach(player -> player.sendMessage("Invulnerabilidade comecando!"));
                            setState(State.INVULNERABILITY);
                        }
                        break;
                    case INVULNERABILITY:
                        i = 0;
                        if (Bukkit.getOnlinePlayers().size() < 5) {
                            Bukkit.getOnlinePlayers().forEach(player -> player.sendMessage("Partida iniciando novamente por jogadores insuficientes!"));
                            setState(State.STARTING);
                        } else {
                            Bukkit.getOnlinePlayers().forEach(player -> {
                                player.playSound(player.getLocation(), Sound.LEVEL_UP, 1F, 1F);
                                player.sendMessage("Partida comecou!");
                            });
                            setState(State.GAME);
                        }
                        break;
                }
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

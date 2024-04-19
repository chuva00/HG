package chuva.hg.state;

import java.util.concurrent.TimeUnit;

public enum State {

    STARTING(3, "Comecando"),
    INVULNERABILITY(5, "Invulnerabilidade"),
    GAME(25, "Comecou");

    private final int timing; //in minutes
    private final String name;

    State(Integer timing, String name) {
        this.timing = timing;
        this.name = name;
    }

    public int getTiming() {
        return timing*60;
    }

    public String getName() {
        return name;
    }
}

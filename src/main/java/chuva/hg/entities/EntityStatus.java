package chuva.hg.entities;

public class EntityStatus {


    private final int kills, deaths, wins, loses, mmr;

    public EntityStatus(int kills, int deaths, int wins, int loses, int mmr) {
        this.deaths = deaths;
        this.kills = kills;
        this.loses = loses;
        this.wins = wins;
        this.mmr = mmr;
    }

    public int getDeaths() {
        return deaths;
    }

    public int getKills() {
        return kills;
    }

    public int getLoses() {
        return loses;
    }

    public int getMmr() {
        return mmr;
    }

    public int getWins() {
        return wins;
    }
}

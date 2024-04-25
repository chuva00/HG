package chuva.hg.entities;

public class EntityEconomy {

    private final int points, cash;

    public EntityEconomy(int points, int cash) {
        this.points = points;
        this.cash = cash;
    }

    public int getCash() {
        return cash;
    }

    public int getPoints() {
        return points;
    }
}

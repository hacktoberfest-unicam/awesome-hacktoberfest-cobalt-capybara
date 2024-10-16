package it.alessandrocalista.pokemon;

import it.alessandrocalista.pokemon.status.Status;

import java.util.List;

public class Move {
    private final String name;
    private final String type;
    private final int damage;
    private final Status status;
    private final List<String> goodAgainst;
    private int powerPoints;

    public Move(String name, String type, int damage, Status status, List<String> goodAgainst) {
        this.name = name;
        this.type = type;
        this.damage = damage;
        this.status = status;
        this.goodAgainst = goodAgainst;
    }

    public Move(String name, String type, int damage, Status status, List<String> goodAgainst, int powerPoints) {
        this.name = name;
        this.type = type;
        this.damage = damage;
        this.status = status;
        this.goodAgainst = goodAgainst;
        this.powerPoints = powerPoints;
    }


    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getDamage() {
        return damage;
    }

    public void removePowerPoint() {
        powerPoints--;
    }

    public boolean canUseMove() {
        return powerPoints > 0;
    }

    public int getPowerPoints() {
        return powerPoints;
    }

    public void setPowerPoints(int powerPoints) {
        this.powerPoints = powerPoints;
    }

    public boolean hasStatus() {
        return status != null;
    }

    public List<String> getGoodAgainst() {
        return goodAgainst;
    }

    public Status getStatus() {
        return status;
    }

    public boolean isGoodAgainst(String type) {
        return goodAgainst.contains(type);
    }
}

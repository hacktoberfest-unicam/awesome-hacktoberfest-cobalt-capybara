package it.alessandrocalista.pokemon;

public class PokemonStatistics {
    private final int attack;
    private final int defence;
    private final int speed;

    public PokemonStatistics(int attack, int defence, int speed) {
        this.attack = attack;
        this.defence = defence;
        this.speed = speed;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefence() {
        return defence;
    }

    public int getSpeed() {
        return speed;
    }
}

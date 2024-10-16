package it.alessandrocalista.pokemon.battle.entity;

import it.alessandrocalista.pokemon.Pokemon;
import it.alessandrocalista.pokemon.status.CountingStatus;

public class LivingEntity {
    private static final double BASE_HEALTH = 100D;

    private double health;
    private final Pokemon pokemon;
    private CountingStatus status;
    private boolean critted;

    public LivingEntity(Pokemon pokemon) {
        this.pokemon = pokemon;
        this.health = BASE_HEALTH;
    }

    public LivingEntity(Pokemon pokemon, double health) {
        this.pokemon = pokemon;
        this.health = health;
    }

    public void damage(double damage) {
        health -= damage;
    }

    public double getHealth() {
        return health;
    }

    public void setHealth(double health) {
        this.health = health;
    }

    public Pokemon getPokemon() {
        return pokemon;
    }

    public boolean isFainted() {
        return health <= 0;
    }

    public boolean hasStatus() {
        return status != null;
    }

    public void removeStatus() {
        status = null;
    }

    public CountingStatus getRoundStatus() {
        return status;
    }

    public void increaseStatusAndCancel() {
        if (status == null) return;
        status.increaseRound();
        if (status.shouldBeExtinguished()) status = null;
    }

    public CountingStatus getStatus() {
        return status;
    }

    public boolean isCritted() {
        return critted;
    }

    public void setCritted(boolean critted) {
        this.critted = critted;
    }
}

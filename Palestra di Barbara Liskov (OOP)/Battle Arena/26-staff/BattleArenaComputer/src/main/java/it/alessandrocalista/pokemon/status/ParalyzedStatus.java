package it.alessandrocalista.pokemon.status;

import java.util.concurrent.ThreadLocalRandom;

public class ParalyzedStatus implements Status {
    @Override
    public String getStatusName() {
        return "Paralyzed";
    }

    @Override
    public double turnLength() {
        return 4;
    }

    @Override
    public boolean shouldCancel() {
        return false;
    }

    @Override
    public boolean computeApply() {
        return ThreadLocalRandom.current().nextDouble() < getParalyzedPercentage();
    }

    private double getParalyzedPercentage() {
        return 0.25;
    }
}

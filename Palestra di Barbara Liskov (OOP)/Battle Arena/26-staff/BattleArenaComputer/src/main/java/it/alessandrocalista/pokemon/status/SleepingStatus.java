package it.alessandrocalista.pokemon.status;

import java.util.concurrent.ThreadLocalRandom;

public class SleepingStatus implements Status {
    private static final double WAKE_FORTUNE = 0.25;

    @Override
    public String getStatusName() {
        return "Sleeping";
    }

    @Override
    public double turnLength() {
        return 4;
    }

    @Override
    public boolean shouldCancel() {
        double randomChance = ThreadLocalRandom.current().nextDouble();
        return randomChance < WAKE_FORTUNE;
    }

    @Override
    public boolean computeApply() {
        return true;
    }


}

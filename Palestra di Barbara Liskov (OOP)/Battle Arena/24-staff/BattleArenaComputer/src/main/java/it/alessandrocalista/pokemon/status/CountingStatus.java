package it.alessandrocalista.pokemon.status;

public class CountingStatus {
    private int rounds;
    private final Status status;

    public CountingStatus(Status status) {
        this.status = status;
    }

    public Status getStatus() {
        return status;
    }

    public void increaseRound() {
        rounds++;
    }

    public boolean shouldBeExtinguished() {
        return status.turnLength() <= rounds;
    }
}

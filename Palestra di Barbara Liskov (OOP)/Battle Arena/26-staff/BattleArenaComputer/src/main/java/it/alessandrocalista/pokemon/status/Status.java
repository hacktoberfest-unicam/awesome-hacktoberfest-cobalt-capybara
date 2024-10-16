package it.alessandrocalista.pokemon.status;

public interface Status {
    String getStatusName();

    double turnLength();

    boolean shouldCancel();

    boolean computeApply();
}

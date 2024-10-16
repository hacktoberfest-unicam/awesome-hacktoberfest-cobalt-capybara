package it.alessandrocalista;

import java.util.List;

public class Charizard extends Pokemon {
    public Charizard() {
        super("Charizard", "Fire", 36, 175, List.of("Pirofuoco"));
    }

    @Override
    public Pokemon evolve() {
        return this;
    }
}

package it.alessandrocalista;

import java.util.List;

public class Charmeleon extends Pokemon {
    private Charizard charizard = new Charizard();

    public Charmeleon() {
        super("Charmeleon", "Fire", 16, 125, List.of("Pirofuoco"));
    }

    @Override
    public Pokemon evolve() {
        if (getLevel() == charizard.getLevel()) {
            System.out.println(getName() + " si sta evolvendo in " + charizard.getName() + "!");
            return charizard;
        }
        return this;
    }
}

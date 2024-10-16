package it.alessandrocalista;

import java.util.List;

public class Charmander extends Pokemon {
    Charmeleon charmeleon = new Charmeleon();

    public Charmander() {
        super("Charmander", "Fire", 0, 100, List.of("Pirofuoco"));
    }

    @Override
    public Pokemon evolve() {
        if (getLevel() == charmeleon.getLevel()) {
            System.out.println(getName() + " si sta evolvendo in " + charmeleon.getName() + "!");
            return charmeleon;
        }
        return this;
    }
}

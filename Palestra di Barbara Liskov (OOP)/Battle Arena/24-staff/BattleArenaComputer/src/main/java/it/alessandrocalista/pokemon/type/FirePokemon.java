package it.alessandrocalista.pokemon.type;

import it.alessandrocalista.pokemon.Pokemon;
import it.alessandrocalista.pokemon.PokemonMoveSet;
import it.alessandrocalista.pokemon.PokemonStatistics;

public class FirePokemon extends Pokemon {
    public static final String IDENTIFIER = "Fire";

    public FirePokemon(String name, PokemonStatistics pokemonStatistics, PokemonMoveSet pokemonMoveSet) {
        super(name, IDENTIFIER, pokemonStatistics, pokemonMoveSet);
    }

}

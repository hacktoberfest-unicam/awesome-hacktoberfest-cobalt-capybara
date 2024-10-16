package it.alessandrocalista.pokemon.type;

import it.alessandrocalista.pokemon.Pokemon;
import it.alessandrocalista.pokemon.PokemonMoveSet;
import it.alessandrocalista.pokemon.PokemonStatistics;

public class WaterPokemon extends Pokemon {
    public static final String IDENTIFIER = "Water";

    public WaterPokemon(String name, PokemonStatistics pokemonStatistics, PokemonMoveSet pokemonMoveSet) {
        super(name, IDENTIFIER, pokemonStatistics, pokemonMoveSet);
    }

}

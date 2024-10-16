package it.alessandrocalista.pokemon;

public class Pokemon {
    private final String name;
    private final String type;
    private final PokemonStatistics pokemonStatistics;
    private final PokemonMoveSet pokemonMoveSet;

    public Pokemon(String name, String type, PokemonStatistics pokemonStatistics, PokemonMoveSet pokemonMoveSet) {
        this.name = name;
        this.type = type;
        this.pokemonStatistics = pokemonStatistics;
        this.pokemonMoveSet = pokemonMoveSet;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public PokemonStatistics getPokemonStatistics() {
        return pokemonStatistics;
    }

    public PokemonMoveSet getPokemonMoves() {
        return pokemonMoveSet;
    }

}

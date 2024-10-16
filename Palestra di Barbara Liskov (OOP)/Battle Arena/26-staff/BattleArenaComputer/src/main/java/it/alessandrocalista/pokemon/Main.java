package it.alessandrocalista.pokemon;

import it.alessandrocalista.pokemon.battle.Battle;
import it.alessandrocalista.pokemon.battle.entity.LivingEntity;
import it.alessandrocalista.pokemon.type.ElectricPokemon;
import it.alessandrocalista.pokemon.type.FirePokemon;
import it.alessandrocalista.pokemon.type.WaterPokemon;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        PokemonMoveSet charmanderMoveSet = new PokemonMoveSet();
        charmanderMoveSet.addMove(new Move("Fuoco",
                FirePokemon.IDENTIFIER,
                10,
                null,
                List.of(ElectricPokemon.IDENTIFIER)));
        charmanderMoveSet.addMove(new Move("Fiammocalcio",
                FirePokemon.IDENTIFIER,
                15,
                null,
                List.of(ElectricPokemon.IDENTIFIER)));

        FirePokemon charmander = new FirePokemon("Charmander", new PokemonStatistics(10, 7, 25), charmanderMoveSet);

        PokemonMoveSet squirtleMoveSet = new PokemonMoveSet();
        squirtleMoveSet.addMove(new Move("Cannonacqua",
                WaterPokemon.IDENTIFIER,
                10,
                null,
                List.of(FirePokemon.IDENTIFIER)));

        squirtleMoveSet.addMove(new Move("Pistolacqua",
                WaterPokemon.IDENTIFIER,
                20,
                null,
                List.of(FirePokemon.IDENTIFIER)));

        WaterPokemon squirtle = new WaterPokemon("Squirtle", new PokemonStatistics(6, 7, 30), squirtleMoveSet);
        Battle battle = new Battle(new LivingEntity(charmander, 160), new LivingEntity(squirtle, 160));
        battle.startGameLoop();
    }
}

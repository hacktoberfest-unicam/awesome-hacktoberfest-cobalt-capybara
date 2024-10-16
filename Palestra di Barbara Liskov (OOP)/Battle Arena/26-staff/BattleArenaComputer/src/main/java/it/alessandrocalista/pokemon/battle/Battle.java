package it.alessandrocalista.pokemon.battle;

import it.alessandrocalista.pokemon.Move;
import it.alessandrocalista.pokemon.Pokemon;
import it.alessandrocalista.pokemon.PokemonMoveSet;
import it.alessandrocalista.pokemon.PokemonStatistics;
import it.alessandrocalista.pokemon.battle.entity.LivingEntity;
import it.alessandrocalista.pokemon.status.ParalyzedStatus;
import it.alessandrocalista.pokemon.status.SleepingStatus;
import it.alessandrocalista.pokemon.status.Status;

import java.util.concurrent.ThreadLocalRandom;

public class Battle {
    private final LivingEntity firstEntity;
    private final LivingEntity secondEntity;

    public Battle(LivingEntity firstEntity, LivingEntity secondEntity) {
        this.firstEntity = firstEntity;
        this.secondEntity = secondEntity;
    }

    public void startGameLoop() {
        while (true) {
            if (checkForGameEnd()) break;
            firstEntity.increaseStatusAndCancel();
            secondEntity.increaseStatusAndCancel();
            executePokemonTurn(firstEntity, secondEntity);
        }

        System.out.println("Lo scontro è terminato!");
        LivingEntity winner = getWinner();

        System.out.printf("Il vincitore di questa battaglia è %s con %s rimanenti!\n",
                winner.getPokemon().getName(),
                winner.getHealth());
    }

    private void executePokemonTurn(LivingEntity firstEntity, LivingEntity secondEntity) {
        Pokemon firstPokemon = firstEntity.getPokemon();
        Pokemon secondPokemon = secondEntity.getPokemon();

        PokemonMoveSet firstPokemonMoveSet = firstPokemon.getPokemonMoves();
        PokemonMoveSet secondPokemonMoveSet = secondPokemon.getPokemonMoves();

        if (firstEntity.isCritted()) {
            firstEntity.setCritted(false);
            return;
        }

        if (!shouldCancelAttackOfEntity(firstEntity)) {
            Move move = firstPokemonMoveSet.getRandomMove();
            double damage = calculateDamageAndEffects(firstEntity, move, secondEntity);
            secondEntity.damage(damage);

            System.out.printf("%s ha attaccato %s con %s\n",
                    firstPokemon.getName(),
                    secondPokemon.getName(),
                    move.getName());

            boolean critDamage = testForCritical();
            if (critDamage) secondEntity.setCritted(true);
        }

        if (secondEntity.isCritted()) {
            secondEntity.setCritted(false);
            return;
        }

        if (!shouldCancelAttackOfEntity(secondEntity)) {
            Move move = secondPokemonMoveSet.getRandomMove();
            double damage = calculateDamageAndEffects(secondEntity, move, firstEntity);
            firstEntity.damage(damage);

            System.out.printf("%s ha attaccato %s con %s\n",
                    secondPokemon.getName(),
                    firstPokemon.getName(),
                    move.getName());

            boolean critDamage = testForCritical();
            if (critDamage) firstEntity.setCritted(true);
        }
    }

    private boolean testForCritical() {
        return Math.random() < 0.15;
    }

    private boolean shouldCancelAttackOfEntity(LivingEntity entity) {
        if (entity.hasStatus()) {
            Status status = entity.getRoundStatus().getStatus();

            if (status instanceof SleepingStatus sleepingStatus && sleepingStatus.shouldCancel()) {
                entity.removeStatus();
                System.out.printf("%s si è svegliato dal sonno!\n");
            } else if (status instanceof ParalyzedStatus paralyzedStatus && paralyzedStatus.shouldCancel()) {
                entity.removeStatus();
                System.out.println("%s non è più paralizzato!\n");
            } else {
                return true;
            }
        }

        return false;
    }

    private double calculateDamageAndEffects(LivingEntity attacker,
                                             Move move,
                                             LivingEntity defender) {
        Pokemon attackerPokemon = attacker.getPokemon();
        Pokemon defenderPokemon = defender.getPokemon();

        PokemonStatistics attackerStats = attackerPokemon.getPokemonStatistics();
        PokemonStatistics defenderStats = defenderPokemon.getPokemonStatistics();

        boolean superEffective = move.isGoodAgainst(defenderPokemon.getType());
        double multiplier = superEffective ? 2 : 1;

        double baseDamage = attackerStats.getAttack() - defenderStats.getDefence();
        double moveCalculatedDamage = baseDamage + (move.getDamage() * multiplier);
        boolean avoidDamage = canAvoidDamage(defenderStats);

        if (avoidDamage) return 0d;
        return moveCalculatedDamage;
    }

    private boolean canAvoidDamage(PokemonStatistics defendStatistics) {
        return ThreadLocalRandom.current().nextDouble(0, (defendStatistics.getSpeed() / 100d)) > 0.75;
    }

    public LivingEntity getWinner() {
        if (firstEntity.isFainted()) return secondEntity;
        if (secondEntity.isFainted()) return firstEntity;
        return null;
    }

    private boolean checkForGameEnd() {
        return firstEntity.isFainted() || secondEntity.isFainted();
    }

}

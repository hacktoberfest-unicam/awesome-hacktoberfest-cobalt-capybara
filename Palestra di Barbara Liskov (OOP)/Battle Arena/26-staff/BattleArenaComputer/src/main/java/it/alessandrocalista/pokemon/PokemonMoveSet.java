package it.alessandrocalista.pokemon;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

public class PokemonMoveSet {
    private final Map<String, Move> moves = new HashMap<>();

    public Optional<Move> getMove(String moveName) {
        return Optional.ofNullable(moves.get(moveName));
    }

    public void addMove(Move move) {
        moves.put(move.getName(), move);
    }

    public Move getRandomMove() {
        List<String> moves = getMoveNames();
        int size = moves.size();
        int random = ThreadLocalRandom.current().nextInt(size);
        Optional<Move> randomMoveName = getMove(moves.get(random));
        Move move = randomMoveName.orElse(null);
        if (move == null) {
            throw new IllegalStateException("it.alessandrocalista.pokemon.Pokemon has no moves registered.");
        }

        return randomMoveName.get();
    }

    private List<String> getMoveNames() {
        return moves.keySet().stream().toList();
    }
}

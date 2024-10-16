package it.alessandrocalista;

import java.util.List;

public abstract class Pokemon {
    private final String name;
    private final String type;
    private int level;
    private final int hp;
    private final List<String> moves;

    public Pokemon(String name, String type, int level, int hp, List<String> moves) {
        this.name = name;
        this.type = type;
        this.level = level;
        this.hp = hp;
        this.moves = moves;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getLevel() {
        return level;
    }

    public int getHp() {
        return hp;
    }

    public List<String> getMoves() {
        return moves;
    }

    public void levelUp() {
        if (level >= 100) return;
        level++;
    }

    public abstract Pokemon evolve();
}

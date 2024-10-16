class Pokemon {
    private String name;
    private String type;
    private int hp;
    private List<String> moves;
    private Map<String, Integer> stats;

    public Pokemon(String name, String type, int hp, List<String> moves, Map<String, Integer> stats) {
        this.name = name;
        this.type = type;
        this.hp = hp;
        this.moves = moves;
        this.stats = stats;
    }

    public void attack(Pokemon target, String move) {
        System.out.println(this.name + " uses " + move + " on " + target.getName() + "!");
        int damage = calculateDamage(move, target.getType());
        target.defend(damage);
    }

    private int calculateDamage(String move, String targetType) {
        // Qui puoi implementare la logica per calcolare il danno basato sulla mossa e sul tipo del bersaglio
        return 10; // Esempio di valore fisso per semplicità
    }

    public void defend(int damage) {
        this.hp -= damage;
        System.out.println(this.name + " takes " + damage + " damage. " + this.hp + " HP left.");
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getHp() {
        return hp;
    }
}

class Battle {
    public void startBattle(Pokemon pokemon1, Pokemon pokemon2) {
        while (pokemon1.getHp() > 0 && pokemon2.getHp() > 0) {
            pokemon1.attack(pokemon2, "SELECTED_MOVE"); // Sostituisci SELECTED_MOVE con la mossa scelta
            if (pokemon2.getHp() > 0) {
                pokemon2.attack(pokemon1, "SELECTED_MOVE"); // Sostituisci SELECTED_MOVE con la mossa scelta
            }
        }
        if (pokemon1.getHp() > 0) {
            System.out.println(pokemon1.getName() + " wins!");
        } else {
            System.out.println(pokemon2.getName() + " wins!");
        }
    }
}
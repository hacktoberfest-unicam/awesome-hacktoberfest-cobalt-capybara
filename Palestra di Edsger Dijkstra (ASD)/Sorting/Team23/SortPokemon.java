import java.util.HashMap;

public class SortPokemon {
    public static void main(String[] args) {
        HashMap<String, Integer> pokedex = new HashMap<String, Integer>();

        pokedex.put("Bulbasaur", 35);
        pokedex.put("Charmander", 54);
        pokedex.put("Squirtle", 23);
        pokedex.put("Pikachu", 78);

        sortBasedOnHP(pokedex);

        pokedex.forEach((key, value) -> {
            System.out.println(key + " has HP: " + value);
        });

    }

    private static void sortBasedOnHP(HashMap<String, Integer> pokedex) {
        pokedex.forEach((key, value) -> {
            pokedex.forEach((key2, value2) -> {
                if (value > value2) {
                    int temp = pokedex.get(key);
                    pokedex.put(key, pokedex.get(key2));
                    pokedex.put(key2, temp);
                }
            });
        });
    }
}
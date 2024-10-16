import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Collections;

public class SortPokemons {
    public static void main(String[] args) {
        HashMap<String, Integer> pokemons = new HashMap<>();

        pokemons.put("Pikachu", 35);
        pokemons.put("Charizard", 78);
        pokemons.put("Bulbasaur", 45);
        pokemons.put("Squirtle", 44);

        LinkedHashMap<String, Integer> sortedPokemons = bubbleSort(pokemons);
        System.out.println("Sorted by HP: " + sortedPokemons);
    }

    public static LinkedHashMap<String, Integer> bubbleSort(HashMap<String, Integer> pokemons) {
        // Convert HashMap to a list of Map.Entry
        List<Map.Entry<String, Integer>> entryList = new ArrayList<>(pokemons.entrySet());

        // Implement the bubble sort on the list
        int n = entryList.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (entryList.get(j).getValue() > entryList.get(j + 1).getValue()) {
                    // Swap
                    Collections.swap(entryList, j, j + 1);
                }
            }
        }

        // Rebuild the sorted LinkedHashMap
        LinkedHashMap<String, Integer> sortedPokemons = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> entry : entryList) {
            sortedPokemons.put(entry.getKey(), entry.getValue());
        }

        return sortedPokemons;
    }
}
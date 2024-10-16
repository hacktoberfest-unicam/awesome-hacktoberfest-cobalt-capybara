import java.util.Scanner;
import java.util.HashMap;

public class SearchPokemon {
    public static void main(String[] args) {
        HashMap<Integer, String> pokedex = new HashMap<Integer, String>();

        pokedex.put(0, "Bulbasaur");
        pokedex.put(1, "Charmander");
        pokedex.put(2, "Squirtle");
        pokedex.put(3, "Pikachu");

        search_pokemon(pokedex);
    }

    private static void search_pokemon(HashMap<Integer, String> pokedex) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the name of the Pokemon you want to search for: ");
        String pokemonName = scanner.nextLine();

        for (int i = 0; i < pokedex.size(); i++) {
            if (pokedex.get(i).equals(pokemonName)) {
                System.out.println("Pokemon found at index: " + i);
                return;
            }
        }
    }
}
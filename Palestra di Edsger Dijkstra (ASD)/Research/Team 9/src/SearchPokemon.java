import utils.std.*;

public class SearchPokemon{
    public static void main(String[] args) {
        String[][] pokedex = {
            {"1", "Bulbasaur"},
            {"2", "Ivysaur"},
            {"3", "Venusaur"},
            {"4", "Charmander"},
        };
        
        StdOut.println("Enter the name of a pokemon: ");
        String searchKey = StdIn.readString();

        String result = linearSearch(pokedex, searchKey);
        if (result != null) {
            System.out.println("Pokémon found: " + result);
        } else {
            System.out.println("Pokémon not found.");
        }
    }

    public static String linearSearch(String[][] pokedex, String nameOrId) {
        for (String[] pokemon : pokedex) {
            if (pokemon[0].equals(nameOrId) || pokemon[1].equals(nameOrId)) {
                return pokemon[1];
            }
        }
        return null;
    }
}
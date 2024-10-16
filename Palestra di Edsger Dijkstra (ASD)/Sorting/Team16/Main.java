import java.util.*;
public class Main {
    public static void main(String[] args) {
        List<Pokemon> pokemon = new ArrayList<>();
        pokemon.add(new Pokemon("Bulbasaur",50));
        pokemon.add(new Pokemon("Charmander",40));
        pokemon.add(new Pokemon("Squirle",10));
        pokemon.add(new Pokemon("Pikachu",60));
        Sort sort = new BubbleSort();
        sort.sort(pokemon);
        for(int i = 0; i < pokemon.size(); i++)
            System.out.println(pokemon.get(i).toString());
    }
}
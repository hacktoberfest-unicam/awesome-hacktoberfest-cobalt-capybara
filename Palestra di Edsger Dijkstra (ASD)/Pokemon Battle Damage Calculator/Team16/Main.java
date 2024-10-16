import java.util.*;
public class Main {
    public static void main(String[] args) {
        HashMap<String,Integer> bulbMoves = new HashMap<>();
        bulbMoves.put("Frustata", 70);
        bulbMoves.put("Azione", 35);
        bulbMoves.put("Foglielama", 55);
        bulbMoves.put("Seme bomba", 80);
        Pokemon bulb = new Pokemon("Bulbasaur","Grass", 100,90, bulbMoves);
        HashMap<String,Integer> charMoves = new HashMap<>();
        charMoves.put("Graffio", 40);
        charMoves.put("Braciere", 40);
        charMoves.put("Dragospiro", 60);
        charMoves.put("Rogodenti", 65);
        Pokemon charmander = new Pokemon("Chamander","Fire",110,100,charMoves);
        System.out.println(charmander.calculate_damage(bulb));
    }
}
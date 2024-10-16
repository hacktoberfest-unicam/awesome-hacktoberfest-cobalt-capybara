import utils.std.*;
import java.util.ArrayList;


public class App {
    public static void main(String[] args) throws Exception {
        ArrayList<String> strongP1 = new ArrayList<String>();
        strongP1.add("Water");
        strongP1.add("Fire");

        ArrayList<String> strongP2 = new ArrayList<String>();
        strongP1.add("Grass");
        strongP1.add("Electric");
        
        
        Pokemon pikachu = new Pokemon("Pikachu", "Electric", 55, 40, new String[]{"Thunderbolt"}, strongP1);
        Pokemon charmander = new Pokemon("Charmander", "Fire", 52, 43, new String[]{"Ember"}, strongP2);

        int damage = pikachu.calculateDamage(charmander);
        System.out.println(pikachu.name + " deals " + damage + " damage to " + charmander.name + "!");
    }
}

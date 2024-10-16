import java.util.ArrayList;
import java.util.Hashtable;

public class BattleCalculations {
    public static void main(String[] args) {
        ArrayList<String> bulbasaurTypes = new ArrayList<String>();
        bulbasaurTypes.add("water");
        Hashtable<String, Integer> bulbasaurMovesPowerMap = new Hashtable<String, Integer>();
        bulbasaurMovesPowerMap.put("DoppiaSberla", 15);
        bulbasaurMovesPowerMap.put("BottaInTesta", 70);
        Pokemon bulbasaur = new Pokemon("Bulbasaur", "Electric", 55, 40, bulbasaurMovesPowerMap, bulbasaurTypes);

        ArrayList<String> charmanderTypes = new ArrayList<String>();
        charmanderTypes.add("grass");
        Hashtable<String, Integer> charmanderMovesPowerMap = new Hashtable<String, Integer>();
        charmanderMovesPowerMap.put("Graffio", 40);
        charmanderMovesPowerMap.put("Braciere", 50);
        Pokemon charmander = new Pokemon("Charmander", "Fire", 49, 49, charmanderMovesPowerMap, charmanderTypes);

        bulbasaur.calculate_damage(charmander);
        System.out.println("Damage dealt by Charmander to Bulbasaur: " + charmander.calculate_damage(bulbasaur));
    }
}
import utils.std.*;

public class App{
    public static void main(String[] args) {
        
        Pokemon pikachu = new Pokemon("Pikachu", 100, 55, 40);
        Pokemon bulbasaur = new Pokemon("Bulbasaur", 105, 50, 45);
        
        battle(pikachu, bulbasaur);
    }

    public static void battle(Pokemon pokemon1, Pokemon pokemon2){
        while((pokemon1.hp > 0) && (pokemon2.hp > 0)){
            int damage = Math.max(pokemon1.attack - pokemon2.defense, 0);
            
            pokemon2.hp -= damage;
            
            StdOut.println(pokemon1.name + " attacks " + pokemon2.name + " for " + damage + " damage. " + pokemon2.name + " has " + pokemon2.hp + " HP left.");
            
            if(pokemon2.hp <= 0){
                StdOut.println(pokemon2.name + " has fainted! " + pokemon1.name + " wins!");
                break;
            }

            damage = Math.max(pokemon2.attack - pokemon1.defense, 0);
            pokemon1.hp -= damage;
            StdOut.println(pokemon2.name + " attacks " + pokemon1.name + " for " + damage + " damage. " + pokemon1.name + " has " + pokemon1.hp + " HP left.");
            
            if(pokemon1.hp <= 0){
                StdOut.println(pokemon1.name + " has fainted! " + pokemon2.name + " wins!");
                break;
            }
        }
    }
}
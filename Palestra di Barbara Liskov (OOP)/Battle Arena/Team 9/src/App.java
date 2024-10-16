import utils.std.*;


public class App {
    public static void main(String[] args) throws Exception {
        StdOut.println("Pokemon Level sorting");

        StdOut.println("\nFirst pokemon:");
        StdOut.print("Name: ");
        String P1_character = StdIn.readString();
        StdOut.print("HP: ");
        int P1_hp = StdIn.readInt();
        StdOut.print("Attack: ");
        int P1_attack = StdIn.readInt();
        StdOut.print("Defense: ");
        int P1_defense = StdIn.readInt();

        StdOut.println("\nSecond pokemon:");
        StdOut.print("Name: ");
        String P2_character = StdIn.readString();
        StdOut.print("HP: ");
        int P2_hp = StdIn.readInt();
        StdOut.print("Attack: ");
        int P2_attack = StdIn.readInt();
        StdOut.print("Defense: ");
        int P2_defense = StdIn.readInt();

        Pokemon P1 = new Pokemon(P1_character, P1_hp, P1_attack, P1_defense);
        Pokemon P2 = new Pokemon(P2_character, P2_hp, P2_attack, P2_defense);

        StdOut.println("\nBattle Start!\n");
        
        while (P1.hp > 0 && P2.hp > 0) {
            
            if (P1.hp <= 0)
                break;

            Pokemon.attack(P1, P2);
            StdOut.println(P1.name + " attacked " + P2.name + " with " + (P1.attack - P2.defense) + " damage.");
            StdOut.println(P2.name + " has " + P2.hp + " hp left.\n");


            if (P2.hp <= 0)
                break;
            Pokemon.attack(P2, P1);
            StdOut.println(P2.name + " attacked " + P1.name + " with " + (P2.attack - P1.defense) + " damage.");
            StdOut.println(P1.name + " has " + P1.hp + " hp left.\n");
        }

        if (P1.hp <= 0) {
            StdOut.println(P2.name + " wins!");
        } else {
            StdOut.println(P1.name + " wins!");
        }

    }
}

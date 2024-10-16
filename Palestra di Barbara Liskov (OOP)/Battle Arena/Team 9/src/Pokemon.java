import utils.std.*;

public class Pokemon{
    String name;
    int hp;
    int attack;
    int defense;

    

    public Pokemon(String name, int hp, int attack, int defense) {
        this.name = name;
        this.hp = hp;
        this.attack = attack;
        this.defense = defense;
    }

    public static void attack(Pokemon stricker, Pokemon target) {
        int damage = stricker.attack - target.defense;
        target.hp -= damage;
        StdOut.println(stricker.name + " attacked " + target.name + " with " + damage + " damage.");
    }
}
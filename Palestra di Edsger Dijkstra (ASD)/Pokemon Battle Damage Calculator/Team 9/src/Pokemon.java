
import java.util.ArrayList;

public class Pokemon{
    String name;
    String type;
    int attack;
    int defense;
    String[] moves;
    ArrayList<String> strong = new ArrayList<String>();

    public Pokemon(String name, String type, int attack, int defense, String[] moves, ArrayList<String> strong) {
        this.name = name;
        this.type = type;
        this.attack = attack;
        this.defense = defense;
        this.moves = moves;
        this.strong = strong;
    }

    public int calculateDamage(Pokemon target) {
        int baseDamage = this.attack - target.defense;
        if (baseDamage < 0) {
            baseDamage = 0;
        }
        return baseDamage * this.typeAdvantage(target);
    }

    public int typeAdvantage(Pokemon target) {
        //se il tipo Ã¨ presente nella lista strong ritorna 2
        if(this.strong.contains(target.type)){
            return 2;
        }
        return 1;
    }
}
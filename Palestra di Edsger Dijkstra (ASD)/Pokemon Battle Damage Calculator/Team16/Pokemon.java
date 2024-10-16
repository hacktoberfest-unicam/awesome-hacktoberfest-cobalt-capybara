import java.util.*;

public class Pokemon{
    private String name;
    private String type;
    private int attack;
    private int defense;
    private HashMap<String,Integer> moves;

    public Pokemon(String name,String type,int attack,int defense,HashMap<String,Integer> moves) {
        this.name = name;
        this.type = type;
        this.attack = attack;
        this.defense = defense;
        this.moves = moves;
    }
    public String getName() {
        return name;
    }
    public String getType() {
        return type;
    }
    public int getAttack(){
        return attack;
    }
    public int getDefense(){
        return defense;
    }
    public HashMap getMoves() {
        return moves;
    }

    public int getDamageMove(String name){
        return moves.get(name);
    }

    public int calculate_damage(Pokemon target){
        int base_damage = this.attack-target.defense;
        if(base_damage < 0){
            base_damage = 0;
        }
        return (int)(base_damage*type_advantage(target));

    }

    public double type_advantage(Pokemon target){
        Advantage adv = new Advantage();
        return adv.getMultiplier(adv.getNumberType(this.type),adv.getNumberType(target.type));
    }
}
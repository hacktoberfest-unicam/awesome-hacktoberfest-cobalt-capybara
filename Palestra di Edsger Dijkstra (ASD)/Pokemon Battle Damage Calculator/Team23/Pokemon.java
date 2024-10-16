import java.util.ArrayList;
import java.util.Dictionary;
import java.util.List;

public class Pokemon {
    private String name = "";
    private String type = "";
    private int attack = 0;
    private int defence = 0;
    private Dictionary<String, Integer> movesPowerMap;
    private ArrayList<String> types;

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getDefence() {
        return defence;
    }

    public void setDefence(int defence) {
        this.defence = defence;
    }

    public Dictionary<String, Integer> getMovesPowerMap() {
        return movesPowerMap;
    }

    public void setMovesPowerMap(Dictionary<String, Integer> movesPowerMap) {
        this.movesPowerMap = movesPowerMap;
    }

    public Pokemon(String name, String type, int attack, int defence, Dictionary<String, Integer> movesPowerMap, ArrayList<String> types) {
        this.name = name;
        this.type = type;
        this.attack = attack;
        this.defence = defence;
        this.movesPowerMap = movesPowerMap;
        this.types = types;
    }

    public List<String> getTypes() {
        return types;
    }

    public void setTypes(ArrayList<String> types) {
        this.types = types;
    }

    public double calculate_damage(Pokemon target) {
        int base_damage = this.attack - target.getDefence();
        if (base_damage < 0) {
            base_damage = 0;
        }

        return base_damage * this.type_advantage(target);
    }

    public double type_advantage(Pokemon target) {

        if (types.contains(target.type)) {
            return 2;
        } else {
            return 0.5;
        }
    }
}
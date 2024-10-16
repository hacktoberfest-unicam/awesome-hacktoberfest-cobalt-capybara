public class Pokemon{
    private String name;
    private int hp;
    public Pokemon(String name, int hp){
        this.name = name;
        this.hp = hp;
    }
    public String getName(){
        return name;
    }

    public int getHp(){
        return hp;
    }

    public String toString(){
        return "Pokemon: " + name + " hp: " + hp;
    }
}
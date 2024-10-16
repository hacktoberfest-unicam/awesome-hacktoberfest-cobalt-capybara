package BattleAndTrading;

public class Pokemon {
    private String name;
    private int hp;
    private int attack;
    private int defence;

    public Pokemon(String name, int hp, int attack, int defence)
    {
        this.name = name;
        this.hp = hp;
        this.attack = attack;
        this.defence = defence;
    }

    public void takeDamage (int damage)
    {
        this.hp -= damage;
        if (this.hp <= 0){this.hp = 0;}
    }

    public boolean isFainted(){return this.hp<=0;}

    public String getName(){return this.name;}
    public int getHp(){return this.hp;}
    public int getAttack(){return this.attack;}
    public int getDefence(){return this.defence;}

}

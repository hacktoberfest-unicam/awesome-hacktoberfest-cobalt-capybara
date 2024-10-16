public class Pokemon {
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

    public int attack(Pokemon opponent) {
        int damage = this.attack - opponent.defense;
        
        damage = Math.max(damage, 0);
        opponent.hp -= damage;
        System.out.println(this.name + " attacca " + opponent.name + " Danno: " + damage);
        return damage;
    }

    public boolean hasFainted() {
        return this.hp <= 0;
    }

    public void displayHP() {
        System.out.println(this.name + " Vita: " + this.hp);
    }
}
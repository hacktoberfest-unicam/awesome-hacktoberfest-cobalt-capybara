package BattleAndTrading;

public class Battle {
    public static void battle(Pokemon pkmn1, Pokemon pkmn2)
    {
        System.out.println("BattleAndTrading.Battle start!");
        int turns=0;
        while (!pkmn1.isFainted() && !pkmn2.isFainted())
        {
            Pokemon attacker = (turns%2 == 0)? pkmn1:pkmn2;
            Pokemon defender = (turns%2 == 0)? pkmn2:pkmn1;

            int damage = attacker.getAttack() - defender.getDefence();
            if (damage < 0){damage = 0;}

            defender.takeDamage(damage);

            System.out.println(attacker.getName() + " attacks " + defender.getName() + " and deals " + damage + " damage.");
            System.out.println(defender.getName() + "'s HP is now " + defender.getHp() + ".");

            if(defender.isFainted()){
                System.out.println(defender.getName() + " has fainted!");
                System.out.println(attacker.getName() + " wins the battle!");
                        break;
            }
            turns++;
        }
    }
}
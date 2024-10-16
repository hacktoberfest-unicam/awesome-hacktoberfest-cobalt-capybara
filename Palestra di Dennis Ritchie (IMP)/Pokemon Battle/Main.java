package BattleAndTrading;

public class Main {

    public static void main(String[] args) {
        Pokemon pikachu = new Pokemon("Pikachu", 100, 55, 30);
        Pokemon bulbasaur = new Pokemon("Bulbasaur", 120, 49, 40);

        System.out.println(pikachu);
        System.out.println(bulbasaur);
        System.out.println();

        Battle.battle(pikachu, bulbasaur);
    }
}
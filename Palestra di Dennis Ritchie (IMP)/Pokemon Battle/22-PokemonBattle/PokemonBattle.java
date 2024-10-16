
public class PokemonBattle {

    public static void battle(Pokemon pokemon1, Pokemon pokemon2) {
        System.out.println("Battaglia tra " + pokemon1.name + " e " + pokemon2.name + " avviata!");

        while (pokemon1.hp > 0 && pokemon2.hp > 0) {
            pokemon1.attack(pokemon2);
            pokemon2.displayHP();


            if (pokemon2.hasFainted()) {
                System.out.println(pokemon2.name + " has perso! " + pokemon1.name + " vince!");
                break;
            }

            pokemon2.attack(pokemon1);
            pokemon1.displayHP();

            if (pokemon1.hasFainted()) {
                System.out.println(pokemon1.name + " has perso! " + pokemon2.name + " vince!");
                break;
            }
        }
    }

    public static void main(String[] args) {
        Pokemon pikachu = new Pokemon("Pikachu", 100, 55, 40);
        Pokemon bulbasaur = new Pokemon("Bulbasaur", 105, 50, 45);

        battle(pikachu, bulbasaur);
    }
}

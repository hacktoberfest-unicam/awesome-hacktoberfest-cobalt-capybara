public class Main{
    public static void main(String[] args) {
        Pokemon[] pokemon = new Pokemon[4];
        pokemon[0] = new Pokemon(1,"Bulbasaur");
        pokemon[1] = new Pokemon(4,"Charmander");
        pokemon[2] = new Pokemon(7,"Squirtle");
        pokemon[3] = new Pokemon(25,"Pikachu");
        Research research = new Research();
        Pokemon p = research.research(pokemon,4);
        System.out.println(p.toString());
        p = research.research(pokemon, 6);
        if(p == null)
            System.out.println("Pokemon non presente nella collezione");
    }
}
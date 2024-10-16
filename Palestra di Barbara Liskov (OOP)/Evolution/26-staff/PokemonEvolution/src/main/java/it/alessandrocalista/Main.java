package it.alessandrocalista;

public class Main {
    public static void main(String[] args) {
        Pokemon pokemon = new Charmander();

        while(true) {
            pokemon.levelUp();
            System.out.println(pokemon.getName() + " e' salito di livello!");

            if(pokemon.getLevel() == 100) {
                System.out.println(pokemon.getName() + " Ha raggiunto il livello 100!");
                break;
            }

            Pokemon newPokemon = pokemon.evolve();
            if (!pokemon.equals(newPokemon)) {
                pokemon = newPokemon;
            }
        }
    }
}
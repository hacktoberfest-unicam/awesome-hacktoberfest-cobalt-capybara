import java.util.*;

public class PokemonTrading {
    public static void addPokemon(Map<String, List<String>> inventory, String trainer, String pokemon) {
        inventory.putIfAbsent(trainer, new ArrayList<>());
        inventory.get(trainer).add(pokemon);
        System.out.println(pokemon + " Aggiunto all'inventario di  " + trainer);
    }

    public static void removePokemon(Map<String, List<String>> inventory, String trainer, String pokemon) {
        if (inventory.containsKey(trainer)) {
            List<String> pokemonList = inventory.get(trainer);
            if (pokemonList.contains(pokemon)) {
                pokemonList.remove(pokemon);
                System.out.println(pokemon + " Rimosso dall'inventario di" + trainer);
            } else {
                System.out.println(pokemon + " Non trovato nell'inventario di " + trainer);
            }
        } else {
            System.out.println(trainer + " Addestratore non trovato.");
        }
    }

    public static void tradePokemon(Map<String, List<String>> inventory, String trainerFrom, String trainerTo, String pokemon) {
        if (inventory.containsKey(trainerFrom) && inventory.containsKey(trainerTo)) {
            List<String> fromPokemonList = inventory.get(trainerFrom);
            if (fromPokemonList.contains(pokemon)) {
                removePokemon(inventory, trainerFrom, pokemon);
                addPokemon(inventory, trainerTo, pokemon);
                System.out.println(trainerFrom + " Scambiato " + pokemon + " con " + trainerTo + ".");
            } else {
                System.out.println(pokemon + " Non trovato nell'inventario di " + trainerFrom);
            }
        } else {
            System.out.println("Uno o più trader non trovati");
        }
    }


    public static void displayInventory(Map<String, List<String>> inventory, String trainer) {
        if (inventory.containsKey(trainer)) {
            System.out.println("Inventario: "  + trainer + inventory.get(trainer));
        } else {
            System.out.println(trainer + " non trovato.");
        }
    }



    public static void main(String[] args) {
        Map<String, List<String>> inventory = new HashMap<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Menù: [1] Aggiungi Pokémon [2] Rimuovi Pokémon [3] Scambia Pokémon [4] Mostra inventario [5] Esci");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("Nome addestratore: ");
                    String trainerAdd = scanner.nextLine();
                    System.out.print("Nome Pokemon: ");
                    String pokemonAdd = scanner.nextLine();
                    addPokemon(inventory, trainerAdd, pokemonAdd);
                    break;
                case "2":
                    System.out.print("Nome addestratore: ");
                    String trainerRemove = scanner.nextLine();
                    System.out.print("Nome Pokemon: ");
                    String pokemonRemove = scanner.nextLine();
                    removePokemon(inventory, trainerRemove, pokemonRemove);
                    break;
                case "3":
                    System.out.print("Addestratore da cui fare il trade:: ");
                    String trainerFrom = scanner.nextLine();
                    System.out.print("Addestratore verso cui fare il trade: ");
                    String trainerTo = scanner.nextLine();
                    System.out.print("Pokemon da scambiare: ");
                    String pokemonTrade = scanner.nextLine();
                    tradePokemon(inventory, trainerFrom, trainerTo, pokemonTrade);
                    break;
                case "4":
                    System.out.print("Addestratore: ");
                    String trainerDisplay = scanner.nextLine();
                    displayInventory(inventory, trainerDisplay);
                    break;
                case "5":
                    System.out.println("Uscita dal programma");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opzione non valida");
                    break;
            }
        }
    }
}

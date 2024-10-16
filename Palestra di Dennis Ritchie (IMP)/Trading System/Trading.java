package BattleAndTrading;

import java.util.Scanner;

class Trainer {
    String name;
    String[] pokemonInventory;
    int pokemonCount;

    public Trainer(String name) {
        this.name = name;
        this.pokemonInventory = new String[10];
        this.pokemonCount = 0;
    }

    public void addPokemon(String pokemon) {
        if (pokemonCount < pokemonInventory.length) {
            pokemonInventory[pokemonCount++] = pokemon;
            System.out.println(pokemon + " added to " + name + "'s inventory.");
        } else {
            System.out.println(name + "'s inventory is full!");
        }
    }

    public void removePokemon(String pokemon) {
        for (int i = 0; i < pokemonCount; i++) {
            if (pokemonInventory[i].equals(pokemon)) {
                for (int j = i; j < pokemonCount - 1; j++) {
                    pokemonInventory[j] = pokemonInventory[j + 1];
                }
                pokemonInventory[--pokemonCount] = null;
                System.out.println(pokemon + " removed from " + name + "'s inventory.");
                return;
            }
        }
        System.out.println(pokemon + " not found in " + name + "'s inventory.");
    }

    public void displayInventory() {
        System.out.println(name + "'s Inventory:");
        if (pokemonCount == 0) {
            System.out.println("No Pokémon in inventory.");
        } else {
            for (int i = 0; i < pokemonCount; i++) {
                System.out.println(pokemonInventory[i]);
            }
        }
    }

    public boolean hasPokemon(String pokemon) {
        for (int i = 0; i < pokemonCount; i++) {
            if (pokemonInventory[i].equals(pokemon)) {
                return true;
            }
        }
        return false;
    }
}

public class Trading {

    static Trainer[] trainers = new Trainer[10];
    static int trainerCount = 0;

    public static Trainer findTrainer(String name) {
        for (int i = 0; i < trainerCount; i++) {
            if (trainers[i].name.equals(name)) {
                return trainers[i];
            }
        }
        return null;
    }

    public static Trainer addTrainer(String name) {
        Trainer existingTrainer = findTrainer(name);
        if (existingTrainer != null) {
            return existingTrainer;
        }

        if (trainerCount < trainers.length) {
            Trainer newTrainer = new Trainer(name);
            trainers[trainerCount++] = newTrainer;
            return newTrainer;
        } else {
            System.out.println("Max number of trainers reached!");
            return null;
        }
    }

    public static void tradePokemon(String trainerFrom, String trainerTo, String pokemon) {
        Trainer fromTrainer = findTrainer(trainerFrom);
        Trainer toTrainer = findTrainer(trainerTo);

        if (fromTrainer == null || toTrainer == null) {
            System.out.println("One or both trainers not found.");
            return;
        }

        if (fromTrainer.hasPokemon(pokemon)) {
            fromTrainer.removePokemon(pokemon);
            toTrainer.addPokemon(pokemon);
            System.out.println(trainerFrom + " traded " + pokemon + " to " + trainerTo + ".");
        } else {
            System.out.println(pokemon + " not found in " + trainerFrom + "'s inventory.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nOptions: [1] Add Pokémon [2] Remove Pokémon [3] Trade Pokémon [4] Show Inventory [5] Quit");
            System.out.print("Choose an option: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("Enter trainer name: ");
                    String trainerAdd = scanner.nextLine();
                    System.out.print("Enter Pokémon to add: ");
                    String pokemonAdd = scanner.nextLine();
                    Trainer trainer1 = addTrainer(trainerAdd);
                    if (trainer1 != null) {
                        trainer1.addPokemon(pokemonAdd);
                    }
                    break;

                case "2":
                    System.out.print("Enter trainer name: ");
                    String trainerRemove = scanner.nextLine();
                    System.out.print("Enter Pokémon to remove: ");
                    String pokemonRemove = scanner.nextLine();
                    Trainer trainer2 = findTrainer(trainerRemove);
                    if (trainer2 != null) {
                        trainer2.removePokemon(pokemonRemove);
                    } else {
                        System.out.println(trainerRemove + " not found.");
                    }
                    break;

                case "3":
                    System.out.print("Enter trainer name to trade from: ");
                    String trainerFrom = scanner.nextLine();
                    System.out.print("Enter trainer name to trade to: ");
                    String trainerTo = scanner.nextLine();
                    System.out.print("Enter Pokémon to trade: ");
                    String pokemonTrade = scanner.nextLine();
                    tradePokemon(trainerFrom, trainerTo, pokemonTrade);
                    break;

                case "4":
                    System.out.print("Enter trainer name: ");
                    String trainerDisplay = scanner.nextLine();
                    Trainer trainer3 = findTrainer(trainerDisplay);
                    if (trainer3 != null) {
                        trainer3.displayInventory();
                    } else {
                        System.out.println(trainerDisplay + " not found.");
                    }
                    break;

                case "5":
                    System.out.println("Exiting the system.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid option. Please choose again.");
            }
        }
    }
}
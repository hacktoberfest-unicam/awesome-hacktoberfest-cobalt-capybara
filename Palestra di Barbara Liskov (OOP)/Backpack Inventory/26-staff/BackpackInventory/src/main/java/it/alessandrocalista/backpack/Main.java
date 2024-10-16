package it.alessandrocalista.backpack;

import it.alessandrocalista.backpack.container.Backpack;
import it.alessandrocalista.backpack.item.Item;

import java.util.Scanner;

public class Main {
    private static final String OPTIONS = """
            1. Mostra oggetti
            2. Aggiungi oggetti
            3. Rimuovi oggetto
            4. Usa oggetto
            5. esci
            """;

    private Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        new Main().app();
    }

    private void app() {
        System.out.println("Inserisci la dimensione del backpack: ");
        int size = scanner.nextInt();
        Backpack backpack = new Backpack(size);

        int option;
        System.out.println(OPTIONS);
        do {
            System.out.println("Inserisci un'opzione: ");
            option = scanner.nextInt();
            scanner.nextLine();  // Consuma la newline dopo il nextInt
            if (option == 5) break;

            handleOptions(option, backpack);
        } while (true);

        System.out.println("Programma terminato!");
    }

    private void handleOptions(int option, Backpack backpack) {
        switch (option) {
            case 1:
                backpack.listItems();
                break;
            case 2:
                handleItemInput(backpack);
                break;
            case 3:
                handleItemRemoval(backpack);
                break;
            case 4:
                handleItemUse(backpack);
                break;
            case 5:
                break;
        }
    }

    private void handleItemUse(Backpack backpack) {
        System.out.println("Inserisci il nome dell'item: ");
        String name = scanner.nextLine();

        Item item = backpack.findItem(name);
        if (item == null) {
            System.out.println("Item non trovato!");
            return;
        }

        item.use();
    }

    private void handleItemRemoval(Backpack backpack) {
        System.out.println("Inserisci il nome dell'item: ");
        String name = scanner.nextLine();
        backpack.removeItem(name);
    }

    private void handleItemInput(Backpack backpack) {
        System.out.println("Inserisci il nome dell'oggetto: ");
        String name = scanner.nextLine();

        System.out.println("Inserisci la categoria dell'oggetto: ");
        String category = scanner.nextLine();

        System.out.println("Inserisci la quantità dell'oggetto: ");
        int quantity = scanner.nextInt();
        scanner.nextLine();

        Item item = new Item(name, category, quantity);
        boolean added = backpack.addItem(item);

        if(!added) {
            System.out.println("Lo zaino è pieno e l'oggetto non è stato aggiunto.");
        }
    }
}



import java.util.Scanner;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Backpack backpack = new Backpack();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Choose an option:");
            System.out.println("1. List Items");
            System.out.println("2. Add Item");
            System.out.println("3. Remove Item");
            System.out.println("4. Use Item");
            System.out.println("5. Exit");

            int userChoice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (userChoice) {
                case 1:
                    backpack.listItems();
                    break;
                case 2:
                    System.out.print("Enter item name: ");
                    String itemName = scanner.nextLine();
                    System.out.print("Enter item category: ");
                    String itemCategory = scanner.nextLine();
                    System.out.print("Enter item quantity: ");
                    int itemQuantity = scanner.nextInt();
                    scanner.nextLine(); // Consume newline character

                    Item newItem = new Item(itemName, itemCategory, itemQuantity);
                    backpack.addItem(newItem);
                    break;
                case 3:
                    System.out.print("Enter the name of the item to remove: ");
                    itemName = scanner.nextLine();
                    backpack.removeItem(itemName);
                    break;
                case 4:
                    System.out.print("Enter the name of the item to use: ");
                    itemName = scanner.nextLine();
                    Item item = backpack.findItem(itemName);
                    if (item != null) {
                        item.use();
                        backpack.removeItem(itemName);
                    } else {
                        System.out.println(itemName + " is not in the backpack.");
                    }
                    break;
                case 5:
                    System.out.println("Exiting the program. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
}

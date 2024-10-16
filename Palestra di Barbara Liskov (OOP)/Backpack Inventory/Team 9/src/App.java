import utils.std.*;

public class App {

    public static void main(String[] args) {
        Backpack backpack = new Backpack(10);
        int choice = 0;
        String name;

        // MENU
        do {
            StdOut.println("Welcome to your backpack inventory!");
            StdOut.println("What would you like to do?");
            StdOut.println("1. View all items in the backpack.");
            StdOut.println("2. Add a new item.");
            StdOut.println("3. Remove an existing item.");
            StdOut.println("4. Use an item (optional).");
            StdOut.println("0. Exit the program.");
            StdOut.println("Please enter a number from 0 to 4:");
            choice = StdIn.readInt();

            // CHOICES
            switch (choice) {
                case 1:
                    backpack.listItems();
                    break;

                case 2:
                    StdOut.println("Please enter the name of the item you would like to add:");
                    name = StdIn.readString();

                    StdOut.println("Please enter the category of the item:");
                    String category = StdIn.readString();

                    StdOut.println("Please enter the quantity of the item:");
                    int quantity = StdIn.readInt();

                    Item item = new Item(name, category, quantity);

                    backpack.addItem(item);

                    break;

                case 3:
                    StdOut.println("Please enter the name of the item you would like to remove:");
                    name = StdIn.readString();

                    backpack.removeItem(name);
                    break;

                case 4:
                    StdOut.println("Please enter the name of the item you would like to use:");
                    name = StdIn.readString();
                    backpack.useItem(name);

                    break;

                case 0:
                    StdOut.println("Goodbye!");
                    break;

                default:
                    StdOut.println("Invalid input. Please try again.");
                    break;

            }
        } while (choice != 0 || choice > 5 || choice < 0);
    }
}
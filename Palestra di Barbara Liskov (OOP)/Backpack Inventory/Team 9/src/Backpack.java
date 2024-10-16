import java.util.ArrayList;
import utils.std.*;

public class Backpack {

    private ArrayList<Item> items;
    private int capacity;

    public Backpack(int capacity) {
        this.capacity = capacity;
        this.items = new ArrayList<>(capacity);
    }

    public void addItem(Item item)
    {
        if (items.size() == capacity - 1) {
            StdOut.println("Il tuo zaino è pieno!");
            return;
        }


        items.add(item);

    }

    public void useItem(String item)
    {

        StdOut.println("Hai utilizzato " + item);
        Item tofind = findItem(item);
        int qty;

        if (tofind == null) {
            StdOut.println("L'oggetto non è presente nel tuo zaino");
            return;
        }
        else
         qty = tofind.use();


        if (qty == 0) {
            StdOut.println("Hai finito " + item);
            removeItem(item);
        }

    }

    public void removeItem(String item)
    {
        for (Item i : items) {
            if (i.getName().equals(item)) {
                items.remove(i);
                break;
            }
        }
    }

    public void listItems() 
    {

        StdOut.println("\n Ecco i tuoi oggetti:");


        for (Item i : items) {
            StdOut.println(i.getName() + "\t" + i.getCategory() + "\t" + i.getQuantity());
        }

        StdOut.print("\n\n");
    }

    
    public Item findItem(String name) {
        for (Item item : items) {
            if (item.getName().equals(name)) {
                return item;
            }
        }
        return null;
    }
}
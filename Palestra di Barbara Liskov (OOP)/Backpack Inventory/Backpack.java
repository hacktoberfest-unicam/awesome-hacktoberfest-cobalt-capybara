import java.util.ArrayList;

public class Backpack {

    private ArrayList<item> items;
    private int capacity;

    public Backpack(int capacity) {
        this.capacity = capacity;
        this.items = new ArrayList<>(capacity);
    }

    public void addItem(Item item)
    {
        items.add(item);

    }

    public void removeItem(Item item)
    {
        items.remove(item);
    }

    public Item[] listItems() 
    {
        return items.toArray(new Item[0]);
    }

    
    public Item itemName(String name) {
        for (Item item : items) {
            if (item.getName().equals(name)) {
                return item;
            }
        }
        return null;
    }
}
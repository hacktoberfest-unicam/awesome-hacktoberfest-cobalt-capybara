

import java.util.HashMap;
import java.util.Map;

public class Backpack {
    private Map<String, Item> items;

    public Backpack() {
        this.items = new HashMap<>();
    }

    public void addItem(Item item) {
        if (items.containsKey(item.getName())) {
            Item existingItem = items.get(item.getName());
            existingItem.setQuantity(existingItem.getQuantity() + item.getQuantity());
        } else {
            items.put(item.getName(), item);
        }
        System.out.println(item.getQuantity() + " " + item.getName() + "(s) added to the backpack.");
    }

    public void removeItem(String itemName) {
        if (items.containsKey(itemName)) {
            Item item = items.get(itemName);
            item.setQuantity(item.getQuantity() - 1);
            if (item.getQuantity() <= 0) {
                items.remove(itemName);
            }
            System.out.println("One " + itemName + " removed from the backpack.");
        } else {
            System.out.println(itemName + " is not in the backpack.");
        }
    }

    public void listItems() {
        if (items.isEmpty()) {
            System.out.println("The backpack is empty.");
        } else {
            for (Item item : items.values()) {
                System.out.println(item.getName() + " (" + item.getCategory() + "): " + item.getQuantity());
            }
        }
    }

    public Item findItem(String itemName) {
        return items.getOrDefault(itemName, null);
    }
}


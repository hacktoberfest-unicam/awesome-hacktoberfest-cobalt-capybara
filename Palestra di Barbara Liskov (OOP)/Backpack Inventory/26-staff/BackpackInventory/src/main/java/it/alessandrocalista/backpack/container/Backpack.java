package it.alessandrocalista.backpack.container;

import it.alessandrocalista.backpack.item.Item;

import java.util.ArrayList;
import java.util.List;

public class Backpack {
    private final List<Item> items = new ArrayList<>();
    private final int capacity;

    public Backpack(int capacity) {
        this.capacity = capacity;
    }

    public boolean addItem(Item item) {
        if (items.size() >= capacity) {
            return false;
        }

        Item backpackItem = findItem(item.getName());
        if (backpackItem != null) {
            backpackItem.setQuantity(backpackItem.getQuantity() + item.getQuantity());
            return true;
        }

        items.add(item);
        return true;
    }

    public void removeItem(String name) {
        Item item = findItem(name);
        if (item == null) return;
        items.remove(item);
    }

    public void listItems() {
        for (Item item : items) {
            if (item == null) continue;
            System.out.println(item);
        }
    }


    public Item findItem(String name) {
        for (Item item : items) {
            if (item.getName().equals(name)) return item;
        }
        return null;
    }
}

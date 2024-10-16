package it.alessandrocalista.backpack.item;

public class Item {
    private static final String FORMAT = "%sx di %s appartenente alla categoria %s";
    private final String name;
    private final String category;
    private int quantity;

    public Item(String name, String category, int quantity) {
        this.name = name;
        this.category = category;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void use() {
        System.out.println("Hai usato " + name);
        quantity--;
    }

    @Override
    public String toString() {
        return String.format(FORMAT, quantity, name, category);
    }
}

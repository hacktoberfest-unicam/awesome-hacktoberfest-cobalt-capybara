public class Item{
    String name;
    String category;
    int quantity;

    public Item(String name, String category, int quantity){
        this.name = name;
        this.category = category;
        this.quantity = quantity;
    }

    //get
    public int getQuantity() {
        return quantity;
    }

    public String getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }

    //set
    public void setName(String name) {
        this.name = name;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int use(){
        System.out.println("You used the item: " + name);
        quantity--;
        return quantity;
    }
}
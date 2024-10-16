

public class Item {
        private String name;
        private String category;
        private int quantity;

        public Item(String name, String category, int quantity) {
            this.name = name;
            this.category = category;
            this.quantity = quantity;
        }

        public void use() {
            System.out.println("You used a " + this.name + "!");
            // Ulteriore comportamento può essere implementato qui
        }

        // Getter per gli attributi
        public String getName() {
            return name;
        }

        public String getCategory() {
            return category;
        }

        public int getQuantity() {
            return quantity;
        }

        // Setter per gli attributi
        public void setName(String name) {
            this.name = name;
        }

        public void setCategory(String category) {
            this.category = category;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }
}

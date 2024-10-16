class Pokemon {
    public String name;
    public String type;
    public int level;
    public int hp;
    public String[] moves;

    public Pokemon(String name, String type, int level, int hp, String[] moves) {
        this.name = name;
        this.type = type;
        this.level = level;
        this.hp = hp;
        this.moves = moves;
    }

    public void levelUp() {
        this.level += 1;
        System.out.println(this.name + " livellato a " + this.level + "!");
        evolve();
    }

    public void evolve() {
        // non fa nulla nella classe base
    }

    public void displayStatus() {
        System.out.println("Name: " + this.name + ", Type: " + this.type + ", Level: " + this.level + ", HP: " + this.hp);
        System.out.print("Moves: ");
        for (String move : this.moves) {
            System.out.print(move + " ");
        }
        System.out.println("\n");
    }
}
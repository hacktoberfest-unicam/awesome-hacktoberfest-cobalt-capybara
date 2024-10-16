class Charmander extends Pokemon {
    public Charmander(String name, int level, int hp, String[] moves) {
        super(name, "Fire", level, hp, moves);
    }

    @Override
    public void evolve() {
        if (this.level >= 16) {
            System.out.println(this.name + " evoluto in Charmeleon!");
            this.name = "Charmeleon"; 
        }
    }
}
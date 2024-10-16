class Charmeleon extends Pokemon {
    public Charmeleon(String name, int level, int hp, String[] moves) {
        super(name, "Fire", level, hp, moves);
    }

    @Override
    public void evolve() {
        if (this.level >= 36) {
            System.out.println(this.name + " evoluto in un  Charizard!");
            this.name = "Charizard";
        }
    }
}

public class Charmeleon extends Charmander
{
    public Charmeleon(String nome, String tipo, int livello, int puntiVita, String[] mosse) {
        super(nome, tipo, livello, puntiVita, mosse);
    }
    @Override
    public Pokemon evolve()
    {
        this.level = this.level + 1;
        if(this.level >= 36)
        {
            System.out.println(this.name + " is evolving to Charizard!");
            return new Charizard("charizard", this.type, this.level, this.hp, this.moves);
        }
        else
        {
            return this;
        }

    }
}
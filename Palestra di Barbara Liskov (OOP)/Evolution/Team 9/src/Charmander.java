
public class Charmander extends Pokemon
{
    public Charmander(String nome, String tipo, int livello, int puntiVita, String[] mosse) 
    {
        super(nome, tipo, livello, puntiVita, mosse);
    }

    @Override
    public Pokemon evolve()
    {
        System.out.println(this.level);
        if(this.level == 16)
        {
            System.out.println(this.name + " is evolving to Charmeleon!");
            return new Charmeleon("charmeleon", this.type, this.level, this.hp, this.moves);
        }
        else
        {
            return this;
        }

    }
}

public abstract class Pokemon
{
    //ATTRIBUTI
    protected String name;
    protected String type;
    protected Integer level;
    protected Integer hp;
    protected String[] moves;

    // Costruttore della classe Pokemon
    public Pokemon(String nome, String tipo, int livello, int puntiVita, String[] mosse) 
    {
        this.name = nome;
        this.type = tipo;
        this.level = livello;
        this.hp = puntiVita;
        this.moves = mosse;
    }


    //METODI GET DELLE VARIABILI
    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public Integer getLevel() {
        return level;
    }

    public Integer getHp() {
        return hp;
    }

    public String[] getMoves() {
        return moves;
    }
    
    //METODI SET DELLE VARIABILI
    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public void setHp(Integer hp) {
        this.hp = hp;
    }

    public void setMoves(String[] moves) {
        this.moves = moves;
    }

    //METHOD LEVEL UP
    public Pokemon levelUp()
    {
        this.level = this.level + 1;

        Pokemon subject = this;
        if(this.level == 36 || this.level == 16){
            subject = subject.evolve();
        }
        System.out.println(subject.name + " leveled up to " + subject.level + "!");
        return subject;
    }

    public abstract Pokemon evolve();

}

public class Research {
    public Pokemon research(Pokemon[] pokemon,int id){
        for(int i = 0;i<pokemon.length;i++){
            if(pokemon[i].getId()==id)
                return pokemon[i];
        }
        return null;
    }
}
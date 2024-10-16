import java.util.*;
public class BubbleSort implements Sort {
    public List<Pokemon> sort(List<Pokemon> pokemon){
        bubbleSort(pokemon);
        return pokemon;
    }

    private void bubbleSort(List<Pokemon> pokemon){
        if(pokemon==null)
            throw new NullPointerException();
        if(pokemon.size()>1) {
            Pokemon temp = null;
            for (int i = pokemon.size() - 1; i > 0; i--) {
                for (int j = 0; j < i; j++) {
                    if (pokemon.get(j).getHp() > pokemon.get(j + 1).getHp()) {
                        temp = pokemon.get(j);
                        pokemon.set(j, pokemon.get(j + 1));
                        pokemon.set(j + 1, temp);
                    }
                }
            }
        }
    }
    /*private List<Pokemon> mergeSort(List<Pokemon> pokemon){
        if(pokemon==null)
            throw new NullPointerException();
        if(pokemon.size()<2)
            return pokemon;
        int m = pokemon.size()/2;
        List<Pokemon> p1 = new ArrayList<>(pokemon.subList(0,m));
        List<Pokemon> p2 = new ArrayList<>(pokemon.subList(m+1,pokemon.size()));
        mergeSort(p1);
        mergeSort(p2);
        merge(p1,p2,pokemon);
        return pokemon;
    }

    private void merge(List<Pokemon> p1,List<Pokemon> p2,List<Pokemon> result){
        result.clear();
        int i,j;
        i = j = 0;
        while(i<p1.size() && j<p2.size()){
            if(p1.get(i).getHp()<p2.get(j).getHp()){
                result.add(p1.get(i));
                i++;
            }
            else{
                result.add(p2.get(j));
                j++;
            }
        }
        if(i!=p1.size()){
            result.addAll(p1.subList(i,p1.size()));
        }
        if(j!=p2.size()){
            result.addAll(p2.subList(j,p2.size()));
        }
    }*/
}
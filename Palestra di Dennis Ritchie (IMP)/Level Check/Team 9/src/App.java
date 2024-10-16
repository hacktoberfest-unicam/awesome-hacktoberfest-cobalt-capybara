import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import utils.std.*;

public class App {
    static int fixed;
    public static void main(String[] args) {

        List<Integer> levels = new ArrayList<>();
        Collections.addAll(levels, 1, 2, 3, 15, 4, 5, 6, 7, 8, 9, 10);
        
        fixed = levels.size();
    
        boolean flag = true;
        int i = 0;

        if(levels.size() != 0){
            do{
                if(levels.get(i) < 0) {
                    flag = false;
                }
                i++;
            }while(i < levels.size() && flag == true);
            
            if(flag) {    //c'è almeno un elemento nell'array, se c'è dev'essere positivo
                sort_pokemon_levels(levels);
            }else{
                StdOut.println("Error: negative value in the array");
            }
        }else{
            StdOut.println("Error: empty array");
        }
    }

    public static boolean is_even(int level) {
        return level % 2 == 0;
    }

    public static void sort_pokemon_levels(List<Integer> levels) {
        List<Integer> even_levels = new ArrayList<>();
        List<Integer> odd_levels = new ArrayList<>();
        
        for (int level : levels) {
            if (is_even(level)) {
                even_levels.add(level);
            } else {
                odd_levels.add(level);
            }
        }

        Collections.sort(even_levels);
        Collections.sort(odd_levels);

        StdOut.println("Even levels:"); 
        for (int level : even_levels) {
            StdOut.println(level);
        }
        StdOut.println("Odd levels:");
        for (int level : odd_levels) {
            StdOut.println(level);
        }
    }
}
import java.util.ArrayList;
import java.util.List;

public class PokemonLevelSorter {

    public static boolean isEven(int level) {
        return level % 2 == 0;
    }

    public static List<List<Integer>> sortPokemonLevels(List<Integer> levels) {
        List<Integer> evenLevels = new ArrayList<>();
        List<Integer> oddLevels = new ArrayList<>();

        for (int level : levels) {
            if (isEven(level)) {
                evenLevels.add(level);
            } else {
                oddLevels.add(level);
            }
        }

        List<List<Integer>> sortedLevels = new ArrayList<>();
        sortedLevels.add(evenLevels);
        sortedLevels.add(oddLevels);

        return sortedLevels;
    }

    public static void main(String[] args) {
        List<Integer> levels = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<List<Integer>> sortedLevels = sortPokemonLevels(levels);

        System.out.println("Even levels: " + sortedLevels.get(0));
        System.out.println("Odd levels: " + sortedLevels.get(1));
    }
}


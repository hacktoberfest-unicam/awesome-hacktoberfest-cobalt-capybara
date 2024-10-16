package BattleAndTrading;

public class LevelCheck {

    public static boolean isEven(int level) {return level %2 == 0;}

    public static int[][] sortLevels(int[] levels) {
        int evenCount = 0;
        int oddCount = 0;

        for (int level : levels) {
            if (isEven(level)) {evenCount++;}
            else
            {oddCount++;}
        }

        int[] evenLevels = new int[evenCount];
        int[] oddLevels = new int[oddCount];

        int evenIndex = 0;
        int oddIndex = 0;

        for (int level : levels) {
            if (isEven(level)) {evenLevels[evenIndex++] = level;}
            else
            {oddLevels[oddIndex++] = level;}
        }

        return new int[][]{evenLevels, oddLevels};
    }

    public static void main(String[] args) {
        int[] levels = {5, 8, 13, 24, 7, 18, 9, 14};

        int[][] sortedLevels = sortLevels(levels);

        System.out.print("Even levels: [");
        for (int level : sortedLevels[0]) {System.out.print(level + " ");}
        System.out.print("]\n");

        System.out.print("Odd levels: [");
        for (int level : sortedLevels[1]) {System.out.print(level + " ");}
        System.out.print("]");
    }
}
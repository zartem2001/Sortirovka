import java.io.IOException;
import java.util.Arrays;
public class Main {
    public static void main(String[] args) throws IOException {
        int[][] teams = {
                { 45, 31, 24, 22, 20, 17, 14, 13, 12, 10 },
                { 31, 18, 15, 12, 10, 8, 6, 4, 2, 1 },
                { 51, 30, 10, 9, 8, 7, 6, 5, 2, 1 }
        };

        int[] nationalTeam = mergeAll(teams);
        System.out.println(Arrays.toString(nationalTeam)); // [51, 45, 31, 31, 30, 24, 22, 20, 18, 17]
    }

    /**
     * Метод для слияния всех команд в одну национальную
     */
    public static int[] mergeAll(int[][] teams) {
        int[] mergedArray = new int[10];
        for (int i = 0; i < teams.length; i++) {
            mergedArray = merge(mergedArray, teams[i]);
        }
        return mergedArray;

    }

    /**
     * Метод для слияния двух команд в одну
     */
    public static int[] merge(int[] teamA, int[] teamB) {
        int[] teamC = new int[10];// массив первых 10 участников (из двух команд), отсортированных по рейтингу
        int indexA = 0;
        int indexB = 0;
        int indexC = 0;
        int i = 0;
        while (i < 10) {
            if (teamA[indexA] >= teamB[indexB]) {
                teamC[indexC] = teamA[indexA];
                indexA++;
            } else {
                teamC[indexC] = teamB[indexB];
                indexB++;
            }
            indexC++;
            i++;
        }
        return teamC;
    }
}
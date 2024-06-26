package ch05;

import java.sql.SQLOutput;

public class MultidimensionalArrayByNewExample {
    public static void main(String[] args) {
        int[][] mathScores = new int[2][3];

        mathScores[0][0] = 80;
        mathScores[0][1] = 83;
        mathScores[0][2] = 85;
        mathScores[1][0] = 86;
        mathScores[1][1] = 90;
        mathScores[1][2] = 92;

        int totalStudent = 0;
        int totalMathSum = 0;

        for (int i = 0; i < mathScores.length ; i ++) {
            for ( int j = 0; j < mathScores[i].length ; j++) {
                totalStudent += 1;
                totalMathSum += mathScores[i][j];
            }
        }

        System.out.println(totalStudent);
        System.out.println(totalMathSum);
        System.out.println(totalMathSum / totalStudent);
    }
}

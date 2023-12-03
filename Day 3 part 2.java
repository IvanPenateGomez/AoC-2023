package MyThings;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day3 {
    public static void main(String[] args) throws FileNotFoundException {

        File file = new File("src/MyThings/text.txt");
        Scanner in = new Scanner(file);
        method(in);
    }

    private static void method(Scanner in) {
        char[][] matrix = new char[140][];
        for (int i = 0; i < 140; i++) {
            matrix[i] = in.nextLine().toCharArray();
        }
        boolean add = false;
        int total = 0;
        for (int i = 0; i < 140; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '*') {
                    int nums = checkNumbers(matrix, i, j);
                    total += nums;
                }
            }
        }
        System.out.println(total);
    }

    private static int checkNumbers(char[][] matrix, int i, int j) {
        int num1 = 0, num2 = 0;

        if (i > 0 && isNumber(matrix[i - 1][j]))
            num1 = getNumber(matrix, i - 1, j);
        if (i + 1 < 140 && isNumber(matrix[i + 1][j]))
            if (num1 == 0) num1 = getNumber(matrix, i + 1, j);
            else num2 = getNumber(matrix, i + 1, j);
        if (j > 0 && isNumber(matrix[i][j - 1]))
            if (num1 == 0) num1 = getNumber(matrix, i, j - 1);
            else num2 = getNumber(matrix, i, j - 1);
        if (j + 1 < 140 && isNumber(matrix[i][j + 1]))
            if (num1 == 0) num1 = getNumber(matrix, i, j + 1);
            else num2 = getNumber(matrix, i, j + 1);
        if (j + 1 < 140 && i + 1 < 140 && isNumber(matrix[i + 1][j + 1]))
            if (num1 == 0) num1 = getNumber(matrix, i + 1, j + 1);
            else num2 = getNumber(matrix, i + 1, j + 1);
        if (j + 1 < 140 && i > 0 && isNumber(matrix[i - 1][j + 1]))
            if (num1 == 0) num1 = getNumber(matrix, i - 1, j + 1);
            else num2 = getNumber(matrix, i - 1, j + 1);
        if (j > 0 && i + 1 < 140 && isNumber(matrix[i + 1][j - 1]))
            if (num1 == 0) num1 = getNumber(matrix, i + 1, j - 1);
            else num2 = getNumber(matrix, i + 1, j - 1);
        if (j > 0 && i > 0 && isNumber(matrix[i - 1][j - 1]))
            if (num1 == 0) num1 = getNumber(matrix, i - 1, j - 1);
            else num2 = getNumber(matrix, i - 1, j - 1);

        return num1 * num2;
    }

    private static boolean isNumber(char c) {
        return ('0' <= c && c <= '9');
    }

    private static int getNumber(char[][] matrix, int row, int col) {
        int startCol = col;
        while (startCol >= 0 && matrix[row][startCol] >= '0' && matrix[row][startCol] <= '9') {
            startCol--;
        }
        startCol++; // Adjust to the starting column of the number

        // Traverse to the right until a non-digit character or boundary is encountered
        int endCol = startCol;
        StringBuilder num = new StringBuilder();
        while (endCol < matrix[row].length && matrix[row][endCol] >= '0' && matrix[row][endCol] <= '9') {
            num.append(matrix[row][endCol]);
            matrix[row][endCol++] = '.'; // Assuming you wanted to replace the digits with a dot
        }

        // Extract the number as a substring and convert it to an integer
        String numberStr = num.toString();
        return Integer.parseInt(numberStr);
    }
}

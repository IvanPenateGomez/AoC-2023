package MyThings;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day1 {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("src/MyThings/text.txt");
        Scanner in = new Scanner(file);
        method(in);
    }

    private static void method(Scanner in) {
        int total = 0;
        while (in.hasNextLine()) {
            String line = in.nextLine();

            int first = -1;
            int last = -1;

            for (int i = 0; i < line.length(); i++) {
                if (first == -1) first = getNum(i, line, false);
                if (last == -1) last = getNum(i , line , true);
                if (first != -1 && last != -1) break;
            }

            total += (first + last);
        }

        System.out.println(total);
    }

    private static int getNum(int i , String line, boolean isLast) {
        int n = line.length();
        char c = line.charAt(isLast ? n - i - 1 : i);
        if (c >= '1' && c <= '9') return c - 48;
        else {
            int number;
            if ((c + 3 <= n && !isLast) || (isLast && c - 3 >= 0)) {
                number = checkNum(line.substring((isLast? c-2:c) , (isLast?c+1:c+3)));
                if (number != -1) return number;
            } if ((c + 4 <= n && !isLast) || (isLast && c - 4 >= 0)) {
                number = checkNum(line.substring((isLast? c-3:c) , (isLast?c+1:c+4)));
                if (number != -1) return number;
            } if ((c + 5 <= n && !isLast) || (isLast && c - 5 >= 0)) {
                number = checkNum(line.substring((isLast? c-4:c) , (isLast?c+1:c+5)));
                return number;
            }
        }

        return -1;
    }

    private static int checkNum(String str) {
        return switch (str) {
            case "one" -> 1;
            case "two" -> 2;
            case "three" -> 3;
            case "four" -> 4;
            case "five" -> 5;
            case "six" -> 6;
            case "seven" -> 7;
            case "eight" -> 8;
            case "nine" -> 9;
            default -> -1;
        };


    }
}

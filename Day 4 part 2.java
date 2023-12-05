package MyThings;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class Day4 {
    public static void main(String[] args) throws FileNotFoundException {

        File file = new File("src/MyThings/text.txt");
        Scanner in = new Scanner(file);
        method(in);
    }
    private static void method(Scanner in) {
        int total = 0;
        String line = "";
        HashMap<String , Integer> points = new HashMap<>();
        HashMap<String , String[][]> map = new HashMap<String, String[][]>();
        for (int i = 0; i < 213; i++) {
            line = in.nextLine();
            line = line.replaceAll("  " , " ").replaceAll("  " , " ").replaceAll("  " , " ");
            String gameNumber  = line.split(" ")[1].substring(0,line.split(" ")[1].length()-1);
            line = line.substring(line.indexOf(':') + 2 , line.length());
            String[] myGame = line.substring(line.indexOf('|') + 2, line.length()).split(" ");
            String[] winnerGame = line.substring(0, line.indexOf('|')).split(" ");


            map.put(gameNumber , new String[][]{myGame, winnerGame});
            points.put(gameNumber , 1);
        }

        for (String num : map.keySet())
            getTotal(num , map , points);

        for (String num : points.keySet())
            total += points.get(num);

        System.out.println(total);
    }

    private static void getTotal(String num, HashMap<String , String[][]> map , HashMap<String , Integer> points) {
        int counter = Integer.parseInt(num);
        for (String number : map.get(num)[0])
            for (String winnerNu : map.get(num)[1])
                if (number.equals(winnerNu)) {
                    counter++;
                    String counterStr = String.valueOf(counter);
                    points.put(counterStr , points.get(counterStr) + 1);
                    getTotal(counterStr , map , points);
                }

    }

}

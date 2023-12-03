package MyThings;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day2 {
    public static void main(String[] args) throws FileNotFoundException {

        File file = new File("src/MyThings/text.txt");
        Scanner in = new Scanner(file);
        method(in);
    }

    public Day2() throws FileNotFoundException {
    }

    public static void method(Scanner in){
        int counter = 0;
        while (in.hasNextLine()){
            String line = in.nextLine();
            String[] strSplit = line.split(" ");
            String[] lineArr = getStringArr(line);
            int gameNumber = Integer.parseInt(strSplit[1].substring(0,strSplit[1].length()-1));

            int highestRed = 0;
            int highestBlue = 0;
            int highestGreen = 0;
            int number;
            boolean possible = true;
            for (String str :
                    lineArr) {
                number = Integer.parseInt(str.split(" ")[1]);
                if (str.contains("red") && number > highestRed) highestRed = number;
                else if (str.contains("green") && Integer.parseInt(str.split(" ")[1]) > highestGreen) highestGreen = number;
                else if (str.contains("blue") && Integer.parseInt(str.split(" ")[1]) > highestBlue)highestBlue = number;
            }
            counter+= highestGreen * highestBlue * highestRed;

        }
        System.out.println(counter);
    }

    private static String[] getStringArr(String s) {
        String[] strSplit = s.split(" ");
        String[] str = new String[(strSplit.length - 2) / 2];
        String newStr = "";
        int counter = 0;
        boolean startCounting = false;
        for (char c : s.toCharArray()) {
            if (!startCounting && c == ':')
                startCounting = true;
            else if (startCounting) {
                    if (c != ',' && c != ';') {
                        newStr += c;
                    } else {
                        str[counter++] = newStr;
                        newStr = "";
                    }
                }
        }
        str[counter] = newStr;
        return str;
    }
}


package MyThings;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.Scanner;

public class Day6 {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("src/MyThings/text.txt");
        Scanner in = new Scanner(file);
        method(in);
    }

    public static void method(Scanner in){
        String time = in.nextLine();
        time = time.replaceAll("  " , "").replaceAll("  " , "").replaceAll(" " , "");
        String times = time.substring(time.indexOf(":") + 1);
        BigInteger intArray = new BigInteger(times);

        String dist = in.nextLine();
        dist = dist.replaceAll("  " , "").replaceAll("  " , "").replaceAll(" " , "");
        String dists = dist.substring(dist.indexOf(":") + 1);
        BigInteger distNumber = new BigInteger(dists);

        BigInteger i = intArray;
        while (true)
            if (multiply(new BigInteger(String.valueOf(i)) , intArray).compareTo(distNumber) > 0) {
                System.out.println(i);
                break;
            } else {
                i = i.subtract(new BigInteger("1"));
        }
        BigInteger x = new BigInteger("0");
        while (true)
            if (multiply(new BigInteger(String.valueOf(x)) , intArray).compareTo(distNumber) > 0) {
                System.out.println(x);
                break;
            } else {
                x = x.add(new BigInteger("1"));
            }

}
    public static BigInteger multiply(BigInteger mid, BigInteger intArray){
        return intArray.subtract(mid).abs().multiply(mid);
    }
}

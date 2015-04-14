package mostrecent;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by Masud on 4/4/15.
 */
public class p12791 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
//        Scanner sc = new Scanner(new File("uncategorized/inputs/12791.txt"));
        while (sc.hasNext()) {
            double x = sc.nextDouble();
            double y = sc.nextDouble();
            double diff = y - x;
            int res = (int) Math.ceil(y / diff);
            System.out.println(res);
        }
    }
}

package sequence;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * This class intended to solve the problem of 3n+1 Category Mathmatics and type
 * easy
 *
 * @author Masudul Haque
 */
public class Uva100 {
    public static void main(String[] args) throws IOException {
//        Scanner scanner = new Scanner(System.in);
        Scanner sc = new Scanner(new File("mathmatics/inputs/100.txt"));
        while (sc.hasNext()) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int first = 0, last = 0;
            first = a < b ? a : b;
            last = a > b ? a : b;
            System.out.printf("%d %d %d\n", a, b, getMaximum(first, last));
        }
    }

    private static int getMaximum(int first, int last){
        int max = 0;
        for (int n = first; n <= last; n++) {
            int count = getCountByValue(n);
            if (max < count) {
                max = count;
            }
        }
        return max;
    }

    private static int getCountByValue(int value) {
        int count = 1;
        while (value != 1) {
            if ((value & 1) == 0) { // Bitwise & is more faster than %
                value = value / 2;
            } else {
                value = 3 * value + 1;
            }
            count++;
        }
        return count;
    }
}

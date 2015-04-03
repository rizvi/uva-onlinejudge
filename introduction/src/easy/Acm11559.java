/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package easy;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author Masudul Haque
 */
public class Acm11559 {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc=new Scanner(System.in);
//        Scanner sc = new Scanner(new FileInputStream(new File("11559.txt")));
        while (sc.hasNext()) {
            int N = sc.nextInt();
            int B = sc.nextInt();
            int H = sc.nextInt();
            int W = sc.nextInt();
            int cost = B + 1;
            for (int i = 0; i < H; i++) {
                int price = sc.nextInt();
                for (int j = 1; j <= W; j++) {
                    int bed = sc.nextInt();
                    if (bed >= N) {
                        if (cost > (N * price)) {
                            cost = N * price;
                        }
                    }
                }
            }
            if (cost >= B) {
                System.out.println("stay home");
            } else {
                System.out.println(cost);
            }

        }
    }
}

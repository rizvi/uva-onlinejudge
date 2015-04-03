/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adhoc;

//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author Masudul Haque
 */
public class Acm11498 {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
//        Scanner sc = new Scanner(new FileInputStream(new File("11498.txt")));
        while (true) {
            int testCase = sc.nextInt();
            if (testCase == 0) {
                break;
            }
            int N = sc.nextInt();
            int M = sc.nextInt();
            for (int i = 0; i < testCase; i++) {
                int X = sc.nextInt();
                int Y = sc.nextInt();
                if (N == X || M == Y) {
                    System.out.println("divisa");
                } else {
                    if (X > N && Y > M) {
                        System.out.println("NE");
                    } else if (X > N && Y < M) {
                        System.out.println("SE");
                    } else if (X < N && Y > M) {
                        System.out.println("NO");
                    } else if (X < N && Y < M) {
                        System.out.println("SO");
                    }
                }
            }
        }
    }
}

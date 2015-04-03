/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package numbersystem;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author Masudul Haque
 */
public class Acm11461 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Set<Integer> square = new HashSet<Integer>();
        for (int i = 0; i * i < 100001; i++) {
            square.add(i * i);
        }
        while (true) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            if (a == 0 && b == 0) {
                break;
            }
            int count = 0;
            for (int i = a; i <= b; i++) {
                if(square.contains(i)){
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}

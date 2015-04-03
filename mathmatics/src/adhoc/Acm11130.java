/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adhoc;

import java.util.Scanner;

/**
 *
 * @author Masudul Haque
 */
public class Acm11130 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            String input = sc.nextLine();
            String[] str = input.split(" ");
            int a = Integer.parseInt(str[0]);
            int b = Integer.parseInt(str[1]);
            int v = Integer.parseInt(str[2]);
            int A = Integer.parseInt(str[3]);
            int s = Integer.parseInt(str[4]);
            if(a==0 && b==0 && v==0 && A==0 && s==0){
                break;
            }
            double r = v * (double) s;
            double dx = r * Math.cos(A * Math.PI / 180.0);
            double dy = r * Math.sin(A * Math.PI / 180.0);

            int x = (int) Math.floor(dx / (2.0 * a) + 0.5 + 1e-6);
            int y = (int) Math.floor(dy / (2.0 * b) + 0.5 + 1e-6);

            System.out.printf("%d %d\n", x, y);
        }
    }
}

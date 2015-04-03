/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package numbersystem;

/**
 *
 * @author Masudul Haque
 */
public class Acm640 {

    public static void main(String[] args) {
        boolean arr[] = new boolean[1000001];
        int sum = 0, num = 0;
        for (int i = 1; i <= 1000000; i++) {
            sum = i;
            num = i;
            while (num > 0) {
                sum += num % 10;
                num /= 10;
            }
            if (sum < 1000) {
                arr[sum] = true;
            }
        }
        for (int i = 1; i <=1000000; i++) {
            if (arr[i] == false) {
//                printf("%d\n", i);
                System.out.println(i);
            }
        }
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package recent;

import java.util.Scanner;

/**
 *
 * @author Masudul Haque
 */
public class p12468 {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(true){
            int a=sc.nextInt();
            int b=sc.nextInt();
            if(a== -1 && b== -1){
                break;
            }
            int diff=Math.abs(a-b);
            if(diff>50){
                diff=100-diff;
            }
            System.out.println(diff);
        }
    }
}

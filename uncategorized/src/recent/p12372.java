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
public class p12372 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int testCase=sc.nextInt();
        for (int t = 1; t <= testCase; t++) {
            int L=sc.nextInt();
            int W=sc.nextInt();
            int H=sc.nextInt();
            if(L>20||W>20||H>20){
                System.out.println("Case "+t+": bad");
            }
            else{
                System.out.println("Case "+t+": good");
            }
        }
    }
}

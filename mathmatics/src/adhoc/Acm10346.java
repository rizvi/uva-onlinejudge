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
public class Acm10346 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            String input=sc.nextLine();
            String[] values=input.split(" ");
            int n=Integer.parseInt(values[0]);
            int k=Integer.parseInt(values[1]);
            System.out.println(n+(n-1)/(k-1));
        }
    }
}

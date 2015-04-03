/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mostrecent;

import java.util.Scanner;

/**
 *
 * @author Masudul Haque
 */
public class p12463 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            int a=sc.nextInt();
            int b=sc.nextInt();
            int c=sc.nextInt();
            int d=sc.nextInt();
            int e=sc.nextInt();
            if(a==0 && b==0 && c==0 && d==0 && e==0){
                break;
            }
            int res=a*b*c*d*d*e*e;
            System.out.println(res);
        }
    }
}

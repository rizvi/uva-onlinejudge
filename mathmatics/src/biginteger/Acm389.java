/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package biginteger;

import java.math.BigInteger;
import java.util.Scanner;

/**
 *
 * @author Masudul Haque
 */
public class Acm389 {

    public static void main(String[] args){
        StringBuilder sb=new StringBuilder("");
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String firstValue = sc.next();
            int firstBase = sc.nextInt();
            int resBase = sc.nextInt();
            if(resBase==-1){
                break;
            }
            BigInteger firsToDec = new BigInteger(firstValue, firstBase);
            String res = firsToDec.toString(resBase);
            if (res.length() > 7) {
                sb.append(String.format("%7s\n", "ERROR"));
            } else {
                sb.append(String.format("%7s\n", res.toUpperCase()));
            }
        }
        System.out.print(sb);
    }
}

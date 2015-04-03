/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.math.BigInteger;

/**
 *
 * @author Masudul Haque
 */
public class Test {
    
    public static void main(String[] args) {
        BigInteger first= new BigInteger("A4C", 15);
        String res=first.toString(11);
        System.out.println(res);
    }
}

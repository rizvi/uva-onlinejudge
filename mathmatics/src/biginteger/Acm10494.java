/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package biginteger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

/**
 *
 * @author Masudul Haque
 */
public class Acm10494 {
    
    public static void main(String[] args) throws IOException {
        BufferedReader buff=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer;
        String input;
        while((input=buff.readLine())!=null){
            tokenizer=new StringTokenizer(input);
            BigInteger first=new BigInteger(tokenizer.nextToken());
            String operand=tokenizer.nextToken();
            int n=Integer.parseInt(tokenizer.nextToken());
            if("/".equals(operand)){
                first=first.divide(BigInteger.valueOf(n));
            }
            else if("%".equals(operand)){
                first=first.mod(BigInteger.valueOf(n));
            }
            System.out.println(first);
        }
    }
    
}

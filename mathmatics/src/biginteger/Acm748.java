/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package biginteger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.StringTokenizer;

/**
 *
 * @author Masudul Haque
 */
public class Acm748 {

    public static void main(String[] args) throws IOException {
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader buff = new BufferedReader(new FileReader(new File("748.txt")));
        String input;
        StringTokenizer tokenizer;
        while ((input = buff.readLine()) != null) {
            tokenizer=new StringTokenizer(input);
            double r = Double.parseDouble(tokenizer.nextToken());
            int n = Integer.parseInt(tokenizer.nextToken());
            BigDecimal res = BigDecimal.valueOf(r);            
            res = res.pow(n);
            String resStr=res.toPlainString();
            if(resStr.charAt(0)=='0'){
                resStr=resStr.substring(1, resStr.length());
            }
            System.out.println(resStr);
        }
    }
}

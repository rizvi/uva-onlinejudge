/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package biginteger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/**
 *
 * @author Masudul Haque
 */
public class Acm465 {
    public static void main(String[] args) throws IOException {
        BufferedReader buff=new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader buff=new BufferedReader(new FileReader(new File("465.txt")));
        String input;
        while((input=buff.readLine())!=null){
            String[] str=new String[3];
            int len=0;
            if(input.indexOf('+')!=-1){
                str[1]="+";
                len=input.indexOf('+');
            }
            else{
                str[1]="*";
                len=input.indexOf('*');
            }
            str[0]=input.substring(0,len);
            str[2]=input.substring(len+1);
//            System.out.println(str[0]+  "   "+str[1]+"    "+str[2]);
            BigInteger first=new BigInteger(str[0].trim());
            BigInteger second=new BigInteger(str[2].trim());
            System.out.println(input);
            if(first.compareTo(BigInteger.valueOf(Integer.MAX_VALUE))>0){//= return wrong answer.
                System.out.println("first number too big");
            }
            if(second.compareTo(BigInteger.valueOf(Integer.MAX_VALUE))>0){
                System.out.println("second number too big");
            }
            if("+".equals(str[1])){
                first=first.add(second);
            }
            else if("*".equals(str[1])){
                first=first.multiply(second);
            }
            if(first.compareTo(BigInteger.valueOf(Integer.MAX_VALUE))>0){
                System.out.println("result too big");
            }
        }
    }
}

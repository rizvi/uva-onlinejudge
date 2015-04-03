/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modulo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Masudul Haque
 */
public class Acm602 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        Scanner sc = new Scanner(new FileInputStream(new File("602.txt")));
        SimpleDateFormat sdf = new SimpleDateFormat();
        sdf.setLenient(false);
        while (true) {
            String input = sc.nextLine();
//          String[] str=input.split(" ");
//          int dd=Integer.parseInt(str[0]);
//          int mm=Integer.parseInt(str[1]);
//          int yyyy=Integer.parseInt(str[2]);
//          if(dd==0 && mm==0 && yyyy==0){
//              break;
//          }
            if ("0 0 0".equals(input)) {
                break;
            }
            Date inputDate = null;

            try {
                sdf.applyPattern("MM dd yyyy");
                inputDate = sdf.parse(input);
                sdf.applyPattern("MMMM d, yyyy");
                System.out.print(sdf.format(inputDate));
                sdf.applyPattern("EEEE");
                System.out.println(" is a " + sdf.format(inputDate));
            } catch (ParseException exp) {
                input = input.replaceAll(" ", "/");
                System.out.println(input + " is an invalid date.");
            }
        }
    }
}

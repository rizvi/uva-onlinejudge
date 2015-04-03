package geometry;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author Masudul Haque
 */
public class p12611 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc=new Scanner(System.in);
//        Scanner sc = new Scanner(new File("12611.txt"));
        int T = sc.nextInt();
        for (int i = 1; i <= T; i++) {
            int radius = sc.nextInt();
            int y1=3*radius/2;
            int y2=y1;//3*radius/2;
            int y3= -y1;
            int y4= -y2;
            
            int x1= - (45*radius)/20;
            int x4=x1;
            int x2= (55*radius)/20;
            int x3=x2;
            System.out.printf("Case %d:\n",i);
            System.out.println(x1+" "+y1);
            System.out.println(x2+" "+y2);
            System.out.println(x3+" "+y3);
            System.out.println(x4+" "+y4);            
        }
    }
}

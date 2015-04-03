package getting_started;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by Masud on 4/3/15.
 */
public class p11172 {
    public static void main(String[] args) throws IOException{
//        Scanner sc =new Scanner(new File("introduction/inputs/11172.txt"));
        Scanner sc =new Scanner(System.in);
        int testCase= Integer.parseInt(sc.nextLine());
        for (int test = 0; test <testCase ; test++) {
            String[] nums= sc.nextLine().split(" ");
            int a= Integer.parseInt(nums[0]);
            int b= Integer.parseInt(nums[1]);
            if (a <b){
                System.out.println("<");
            }
            else if( a> b){
                System.out.println(">");
            }
            else{
                System.out.println("=");
            }
        }
    }
}

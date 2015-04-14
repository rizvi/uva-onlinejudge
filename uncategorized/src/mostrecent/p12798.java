package mostrecent;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by Masud on 4/4/15.
 */
public class p12798 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
//        Scanner sc = new Scanner(new File("uncategorized/inputs/12798.txt"));
        while (sc.hasNext()){
            int N= sc.nextInt();
            int M= sc.nextInt();
            int res=0;
            for (int i = 0; i <N; i++) {
                int count=0;
                for (int j = 0; j <M; j++) {
                    int goal= sc.nextInt();
                    if (goal>0){
                        count++;
                    }
                }
                if(count== M){
                    res++;
                }
            }
            System.out.println(res);
        }
    }

}

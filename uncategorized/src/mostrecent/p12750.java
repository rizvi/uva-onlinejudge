package mostrecent;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by cefalo on 4/4/15.
 */
public class p12750 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
//        Scanner sc = new Scanner(new File("uncategorized/inputs/12750.txt"));
        int testCase= Integer.parseInt(sc.nextLine());
        for (int t = 1; t <=testCase ; t++) {
          int ans=0, cur=0;
          boolean end=false;
          int line= Integer.parseInt(sc.nextLine());
            for (int i = 0; i < line ; i++) {
                String input=sc.nextLine();
                if(end){
                    continue;
                }
                if("W".equals(input.trim())){
                    cur=0;
                }
                else {
                    cur++;
                    if (cur>= 3){
                        end=true;
                    }
                }
                ans++;
            }
            if(end){
                System.out.printf("Case %d: %d\n",t,ans);
            }
            else {
                System.out.printf("Case %d: Yay! Mighty Rafa persists!\n",t);
            }

        }
    }
}

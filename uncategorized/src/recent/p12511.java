/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package recent;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Masudul Haque
 */
public class p12511 {
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br=new BufferedReader(new FileReader(new File("12511.txt")));
        int testCase=Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            String[] first=br.readLine().split(" ");
            String[] second=br.readLine().split(" ");
            int firLength=Integer.parseInt(first[0]);
            int secLength=Integer.parseInt(second[0]);
            int[] fArr=new int[firLength];
            int[] sArr=new int[secLength];
            for (int j = 0; j < firLength; j++) {
                fArr[j]=Integer.parseInt(first[j+1]);
            }
            for (int j = 0; j < secLength; j++) {
                sArr[j]=Integer.parseInt(second[j+1]);
            }
            System.out.println(LCIS(fArr, sArr));
        }
    }
    static int LCIS(int[] x, int[] y) {
        int N = x.length, M = y.length;
        int[] common = new int[1501], previous = new int[1501];
        int current, last;
        for (int i = 0; i < N; i++) {
            current = 0;
            last = -1;
            for (int j = 0; j < M; j++) {
                if (x[i] == y[j] && current >= common[j]) {
                    common[j] = current + 1;
                    previous[j] = last;
                }
                if (x[i] > y[j] && current < common[j]) {
                    current = common[j];
                    last = j;
                }
            }
        }

        int l = 0, ind = -1;
        for (int i = 0; i < M; i++) {
            if (common[i] > l) {
                l = common[i];
                ind = i;
            }
        }
        return l;
    }
}

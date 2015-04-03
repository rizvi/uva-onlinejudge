/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package othergame;

import java.io.*;
import java.util.*;
import static java.lang.Integer.*;
public class Acm10903 {
	public static void main(String args[]) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));int c=0;
		for (StringTokenizer st;(st=new StringTokenizer(in.readLine()))!=null;c++) {
			int N=parseInt(st.nextToken());
			if(N==0)break;
			if(c>0)System.out.printf("\n");
			int K=parseInt(st.nextToken());
			int ganados[]=new int[N],perdidos[]=new int[N];
			for(int i=0;i<K*N*(N-1)/2;i++){
				st=new StringTokenizer(in.readLine());
				int J1=parseInt(st.nextToken())-1;
				String mano1=st.nextToken();
				int J2=parseInt(st.nextToken())-1;
				String mano2=st.nextToken();
				if(mano1.equals("rock")){
					if(mano2.equals("scissors")){ganados[J1]++;perdidos[J2]++;}
					else if(mano2.equals("paper")){ganados[J2]++;perdidos[J1]++;}
				}
				else if(mano1.equals("scissors")){
					if(mano2.equals("paper")){ganados[J1]++;perdidos[J2]++;}
					else if(mano2.equals("rock")){ganados[J2]++;perdidos[J1]++;}
				} 
				else if(mano1.equals("paper")){
					if(mano2.equals("rock")){ganados[J1]++;perdidos[J2]++;}
					else if(mano2.equals("scissors")){ganados[J2]++;perdidos[J1]++;}
				} 
			}
			for(int i=0;i<N;i++)
				if(perdidos[i]+ganados[i]>0)System.out.printf(Locale.US,"%.3f\n",1.*ganados[i]/(ganados[i]+perdidos[i]));
				else System.out.printf("-\n");
		}
	}
}

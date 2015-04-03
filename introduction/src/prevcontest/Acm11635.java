/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package prevcontest;
/**
 * @author Juan Sebastian Beltran Rojas
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict T.L.E.
 * @problemId 11635
 * @problemName Hotel Booking
 * @judge http://uva.onlinejudge.org/
 * @category graph
 * @level medium
 * @date 23/07/2010
 **/
import static java.lang.Integer.*;
import java.awt.*;
import java.io.*;
import java.util.*;
public class Acm11635 {
	static final int limiteTiempo = 60*10;
	static TreeSet<Integer> hoteles;
	public static double[] function(ArrayList<Point> lAdy[], int v){
		int n; boolean visitados[] = new boolean[n=lAdy.length];
		double[] sol = new double[n];
		PriorityQueue<double[]> cola = new PriorityQueue<double[]>(n, new Comparator<double[]>() {
			public int compare(double[] o1, double[] o2) {return o1[1]!=o2[1]?(o1[1]<o2[1]?-1:1):(int)o1[0]-(int)o2[0];}
		});
		Arrays.fill(sol, Double.POSITIVE_INFINITY);sol[v]=0;visitados[v]=true;
		cola.add(new double[]{v, 0});
		for(;!cola.isEmpty();){
			double[] ult = cola.poll();
			for(Point u: lAdy[(int)ult[0]])
				if(!visitados[u.x]&&sol[u.x]-1e-10>sol[(int)ult[0]]+u.y){
					visitados[u.x]=true;
					cola.add(new double[]{u.x,sol[u.x]=sol[(int)ult[0]]+u.y});
				}
		}
		return sol;		
	}
	public static void main(String[] args) throws Throwable{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for (int N; (N = parseInt(in.readLine().trim())) != 0; ) {
			ArrayList<Point> lAdy[] = new ArrayList[N];
			for (int i = 0; i < lAdy.length; i++) lAdy[i] = new ArrayList<Point>();
			hoteles = new TreeSet<Integer>();
			StringTokenizer st = new StringTokenizer(in.readLine().trim());
			hoteles.add(0);hoteles.add(N-1);
			for (int i = 0, C = parseInt(st.nextToken()); i < C; i++) 
				hoteles.add(parseInt(st.nextToken()) - 1);
			for (int i = 0, R = parseInt(in.readLine().trim()); i < R; i++) {
				st = new StringTokenizer(in.readLine().trim());
				int desde = parseInt(st.nextToken()) - 1, hasta = parseInt(st.nextToken()) - 1, tiempo = parseInt(st.nextToken());
				lAdy[desde].add(new Point(hasta, tiempo));
				lAdy[hasta].add(new Point(desde, tiempo));
			}
			ArrayList<Point> lAdy1[] = new ArrayList[hoteles.size()];
			for (int i = 0; i < lAdy1.length; i++) lAdy1[i] = new ArrayList<Point>();
			int I = 0;
			for(int v: hoteles){
				double[] d = function(lAdy, v);
				int J = 0;
				for(int u: hoteles){
					if(d[u]<=limiteTiempo)lAdy1[I].add(new Point(J,1));
					J++;
				}
				I++;
			}
			double res = function(lAdy1, 0)[hoteles.size()-1];
			System.out.println(res==Double.POSITIVE_INFINITY?-1:((int)res-1));
		}
	}
}

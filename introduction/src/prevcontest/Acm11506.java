/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package prevcontest;

/**
 * @author Juan Sebastian Beltran Rojas
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @problemId 11506
 * @problemName Angry Programmer
 * @judge http://uva.onlinejudge.org/
 * @category graph
 * @level medium
 * @date 23/07/2010
 *
 */
import static java.lang.Integer.*;
import java.io.*;
import java.util.*;

public class Acm11506 {

    public static void main(String[] args) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for (;;) {
            StringTokenizer st = new StringTokenizer(in.readLine().trim());
            int M = parseInt(st.nextToken()), W = parseInt(st.nextToken());
            if (M == 0 && W == 0) {
                break;
            }
            double[][] mAdy = new double[2 * M][2 * M];
            ArrayList<Integer> lAdy[] = new ArrayList[2 * M];
            for (int i = 0; i < lAdy.length; i++) {
                lAdy[i] = new ArrayList<Integer>();
            }
            for (int i = 0; i < M - 2; i++) {
                st = new StringTokenizer(in.readLine().trim());
                int d = parseInt(st.nextToken()) - 1, c = parseInt(st.nextToken());
                if (c > 0) {
                    mAdy[2 * d][2 * d + 1] = mAdy[2 * d + 1][2 * d] = c;
                    lAdy[2 * d].add(2 * d + 1);
                    lAdy[2 * d + 1].add(2 * d);
                }
            }
            mAdy[0][1] = mAdy[1][0] = Integer.MAX_VALUE;
            mAdy[2 * M - 2][2 * M - 1] = mAdy[2 * M - 1][2 * M - 2] = Integer.MAX_VALUE;
            lAdy[2 * M - 1].add(2 * M - 2);
            lAdy[2 * M - 2].add(2 * M - 1);
            lAdy[0].add(1);
            lAdy[1].add(0);
            for (int i = 0; i < W; i++) {
                st = new StringTokenizer(in.readLine().trim());
                int desde = parseInt(st.nextToken()) - 1, hasta = parseInt(st.nextToken()) - 1, costo = parseInt(st.nextToken());
                if (costo > 0) {
                    mAdy[2 * desde][2 * hasta + 1] = costo;
                    mAdy[2 * hasta][2 * desde + 1] = costo;
                    lAdy[2 * desde].add(2 * hasta + 1);
                    lAdy[2 * hasta].add(2 * desde + 1);
                }
            }
            System.out.println(Math.round(maxFlow(mAdy, 0, 2 * M - 1)));
        }
    }

    static double maxFlow(double[][] capacity, int v1, int v2) { // residualCapacity=capacity-flow
        int n = capacity.length, lAdy[][] = new int[n][], ants[] = new int[n], queue[] = new int[n], v, u;
        double f = 0d, m, flow[][] = new double[n][n], minCap[] = new double[n];
        List h[] = new List[n];
        for (u = 0; u < n; u++) {
            h[u] = new ArrayList<Integer>();
        }
        for (u = 0; u < n; u++) {
            for (v = 0; v < n; v++) {
                if (capacity[u][v] > 1e-10) {
                    h[u].add(v);
                    h[v].add(u);
                }
            }
        }
        for (u = 0; u < n; u++) {
            lAdy[u] = toArr(h[u]);
        }
        for (; (m = bfsEK(capacity, flow, lAdy, ants, minCap, queue, v1, v2)) > 1e-10; f += m) {
            for (v = v2, u = ants[v]; v != v1; v = u, u = ants[v]) {
                flow[u][v] += m;
                flow[v][u] -= m;
            }
        }
        return f;
    }

    static double bfsEK(double[][] capacity, double[][] flow, int[][] lAdy,
            int[] ants, double[] minCap, int[] queue, int v1, int v2) {
        int i, t = 0, u;
        double z;
        Arrays.fill(ants, -1);
        ants[v1] = -2;
        minCap[v1] = Double.POSITIVE_INFINITY;
        for (queue[t++] = v1, i = 0; i < t; i++) {
            for (int v : lAdy[u = queue[i]]) {
                if ((z = capacity[u][v] - flow[u][v]) > 1e-10 && ants[v] == -1) {
                    ants[v] = u;
                    minCap[v] = Math.min(minCap[u], z);
                    if (v == v2) {
                        return minCap[v2];
                    }
                    queue[t++] = v;
                }
            }
        }
        return 0d;
    }

    static int[] toArr(List<Integer> p) {
        int r[] = new int[p.size()], i = 0;
        for (int x : p) {
            r[i++] = x;
        }
        return r;
    }
    /* Este maxFlow no sirve, en revisión
     static public double maxFlow(int desde, int hasta, double[][] c, ArrayList<Integer> lAdy[]){
     int n;double flow = 0, fr[][] = new double[n=c.length][n], f[] = new double[c.length];int P[] = new int[n];
     for(double m;(m=maxFlow(desde, hasta, c, lAdy, P, fr, f))>1e-10;flow+=m)
     for(int u,v=hasta;v!=desde;v=u){
     u=P[v];fr[u][v]+=m;fr[v][u]-=m;
     }
     return flow;
     }
     static public double maxFlow(int desde, int hasta, double[][] c, ArrayList<Integer>[] lAdy, int []P, double [][]fr, double f[]){
     Arrays.fill(P, -1);P[desde]=-2;
     f[desde]=Double.POSITIVE_INFINITY;
     LinkedList<Integer> cola = new LinkedList<Integer>();
     cola.add(desde);
     for(;!cola.isEmpty();){
     int u = cola.removeFirst();
     for(int v: lAdy[u])
     if(P[v]==-1&&c[u][v]-fr[u][v]>1e-10){
     P[v]=u;f[v]=Math.min(f[u], c[u][v]-fr[u][v]);
     if(v!=hasta)cola.add(v);else return f[hasta];
     }
     }
     return 0;
     }*/
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Masud
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class p572 {
    static int [] dx = {1,-1,0,0,1,-1,1,-1};
    static int [] dy = {0,0,1,-1,-1,-1,1,1};
    static char [][] map;
    static boolean isValid(int x,int y){
        return y > -1 && y < map.length && x > -1 && x < map[0].length;
    }
    static void bfs(int x, int y){
        Queue<Integer> q = new LinkedList<Integer>();
        map[y][x] = '*';
        q.add(x);
        q.add(y);
        int x1,y1;
        while(!q.isEmpty()){
            x = q.poll();
            y = q.poll();
            for (int i = 0; i < 8; i++) {
                x1 = x + dx[i];
                y1 = y + dy[i];
                if(isValid(x1,y1) && map[y1][x1] == '@'){
                    q.add(x1);
                    q.add(y1);
                    map[y1][x1] = '*';
                }
            }
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();
        String l = br.readLine();
        int r,c,res;
        String[] sp;
        while(!l.equals("0 0")){
            sp = l.split(" ");
            res = 0;
            r = Integer.parseInt(sp[0]);
            c = Integer.parseInt(sp[1]);
            map = new char[r][c];
            for (int i = 0; i < r; i++) {
                map[i] = br.readLine().toCharArray();
            }
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    if(map[i][j] == '@'){
                        bfs(j, i);
                        res++;
                    }
                }
            }
            out.append(res + "\n");
            l = br.readLine();
        }
        System.out.print(out);
    }
}
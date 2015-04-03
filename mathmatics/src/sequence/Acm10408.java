/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sequence;

/**
 *
 * @author Masudul Haque
 */
public class Acm10408 {

    static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public static void main(String[] args) {
        int n, k;
    
//    while ( scanf("%d %d",&n,&k) == 2 )
//    
//        for (int den=1; den<=n; den++)
//            for (int num=1; num<=den; num++)
//                if ( gcd( num, den ) == 1 )
//                    frac.pb( mp( num, den ) );
//        sort( frac.begin(), frac.end(), cmp );
//        printf("%d/%d\n",frac[k-1].first,frac[k-1].second);
    }
    
    
}

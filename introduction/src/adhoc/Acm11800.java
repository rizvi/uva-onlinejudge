/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adhoc;

/**
 * @author Juan Sebastian Beltran Rojas
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict T.L.E.
 * @problemId 11800
 * @problemName Determine the Shape
 * @judge http://uva.onlinejudge.org/
 * @category geom
 * @level ?
 * @date 27/10/2010
 *
 */
import java.awt.geom.*;
import java.io.*;
import java.util.*;
import static java.lang.Integer.*;

public class Acm11800 {

    static double dist(Point2D p, Point2D q) {
        return (p.getX() - q.getX()) * (p.getX() - q.getX()) + (p.getY() - q.getY()) * (p.getY() - q.getY());
    }

    static boolean doubleEquals(double a, double b, double epsilon) {
        if (Math.abs(a) == Double.POSITIVE_INFINITY && Math.abs(b) == Double.POSITIVE_INFINITY) {
            return true;
        }
        return Math.abs(a - b) <= epsilon;
    }

    static double getPendiente(Line2D l) {
        return (l.getY1() - l.getY2()) / (l.getX1() - l.getX2());
    }

    static boolean sonPerpendiculares(Line2D l1, Line2D l2, double epsilon, boolean sonSegmentos) {
        double m1 = getPendiente(l1), m2 = getPendiente(l2);
        boolean result = (Math.abs(m1) == Double.POSITIVE_INFINITY && doubleEquals(m2, 0, epsilon)) || (Math.abs(m2) == Double.POSITIVE_INFINITY && doubleEquals(m1, 0, epsilon)) || doubleEquals(m1, -m2, epsilon);
        return result && (!sonSegmentos || (sonSegmentos && l1.intersectsLine(l2)));
    }

    static boolean sonParalelas(Line2D l1, Line2D l2, double epsilon) {
        double m1 = getPendiente(l1), m2 = getPendiente(l2);
        return doubleEquals(m1, m2, epsilon) && ((Math.abs(m1) == Double.POSITIVE_INFINITY && !doubleEquals(l1.getX1(), l2.getX2(), epsilon) || (Math.abs(m1) != Double.POSITIVE_INFINITY && (!doubleEquals(m1 * l2.getX1() + (l1.getY1() - m1 * l1.getX1()), l2.getY1(), epsilon)))));
    }

    static double movimientoVectorial(Point2D p, Point2D q, Point2D r) {
        return (q.getX() - p.getX()) * (r.getY() - p.getY()) - (q.getY() - p.getY()) * (r.getX() - p.getX());
    }

    static Point2D[] convexHull(Point2D[] pts, final double epsilon, boolean conBorde) {
        int n = pts.length;
        Point2D[] res = new Point2D[n];
        Point2D p = new Point2D.Double(Double.MAX_VALUE, Double.MAX_VALUE);
        for (Point2D q : pts) {
            if (q.getY() < p.getY() || (doubleEquals(q.getY(), q.getX(), epsilon) && q.getX() < p.getX())) {
                p = q;
            }
        }
        final Point2D P = p;
        Arrays.sort(pts, new Comparator<Point2D>() {
            public int compare(Point2D o1, Point2D o2) {
                if (o1 == P) {
                    return -1;
                }
                if (o2 == P) {
                    return 1;
                }
                double dist1 = Math.atan2(o1.getX() - P.getX(), o1.getY() - P.getY()),
                        dist2 = Math.atan2(o2.getX() - P.getX(), o2.getY() - P.getY());
                return doubleEquals(dist1, dist2, epsilon) ? (dist(P, o1) < dist(P, o2) ? 1 : -1) : (dist1 < dist2 ? -1 : 1);
            }
        });
        int j = Math.min(2, n);
        res[0] = p;
        res[1 % n] = pts[1 % n];
        Point2D p1 = pts[1 % n], p2 = pts[2 % n];
        for (int i = 3; i <= n; i++) {
            if (doubleEquals(movimientoVectorial(p2, p1, pts[i % n]), 0, epsilon) && conBorde || (!doubleEquals(movimientoVectorial(p2, p1, pts[i % n]), 0, epsilon) && movimientoVectorial(p2, p1, pts[i % n]) > 0)) {
                res[j++] = p2;
                p1 = p2;
                p2 = pts[i % n];
            } else {
                p2 = pts[i % n];
            }
        }
        return Arrays.copyOfRange(res, 0, j);
    }

    public static void main(String[] args) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.setOut(new PrintStream("out.out"));
        final double epsilon = 1e-9;
        StringBuilder sb = new StringBuilder();
        for (int c = 0, N = parseInt(in.readLine().trim()); c < N; c++) {
            Point2D[] arr = new Point2D[4];
            for (int i = 0; i < 4; i++) {
                StringTokenizer st = new StringTokenizer(in.readLine().trim());
                arr[i] = new Point2D.Double(parseInt(st.nextToken()), parseInt(st.nextToken()));
            }
            Point2D[] convex = convexHull(arr, epsilon, true);
            String sol = "Ordinary Quadrilateral";
            if (convex.length == 4) {
                double[] distancias = new double[4];
                for (int i = 0; i < convex.length; i++) {
                    distancias[i] = dist(convex[i], (convex[(i + 1) % 4]));
                }
                if (doubleEquals(distancias[0], distancias[2], epsilon) && doubleEquals(distancias[1], distancias[3], epsilon)) {
                    if (doubleEquals(distancias[0], distancias[1], epsilon)) {
                        if (sonPerpendiculares(new Line2D.Double(convex[0], convex[1]), new Line2D.Double(convex[1], convex[2]), epsilon, true)
                                && sonPerpendiculares(new Line2D.Double(convex[2], convex[3]), new Line2D.Double(convex[3], convex[0]), epsilon, true)) {
                            sol = "Square";
                        } else {
                            sol = "Rhombus";
                        }
                    } else if (sonPerpendiculares(new Line2D.Double(convex[0], convex[1]), new Line2D.Double(convex[1], convex[2]), epsilon, true)
                            && sonPerpendiculares(new Line2D.Double(convex[2], convex[3]), new Line2D.Double(convex[3], convex[0]), epsilon, true)) {
                        sol = "Rectangle";
                    } else {
                        sol = "Parallelogram";
                    }
                } else if (sonParalelas(new Line2D.Double(convex[0], convex[1]), new Line2D.Double(convex[2], convex[3]), epsilon)
                        || sonParalelas(new Line2D.Double(convex[1], convex[2]), new Line2D.Double(convex[3], convex[0]), epsilon)) {
                    sol = "Trapezium";
                }
            }
            sb.append("Case " + (c + 1) + ": " + sol + "\n");
        }
        System.out.print(new String(sb));
    }
}
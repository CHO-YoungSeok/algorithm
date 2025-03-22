import java.util.*;

class Point {
    int x, y;
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {

    static int T, n;
    static Point[] points;
    static ArrayList<Integer> listPositive;
    static Boolean[] bIsPositive;
    static double min;

    static void choose(int digit) {
        if(digit == n/2) {
            int sumX = 0;
            int sumY = 0;
            for(int i = 0; i < n; i++) {
                if(bIsPositive[i]) {
                    sumX += points[i].x;
                    sumY += points[i].y;
                } else {
                    sumX -= points[i].x;
                    sumY -= points[i].y;
                }
            }
            double scala = Math.sqrt(Math.pow(sumX, 2) + Math.pow(sumY, 2));
            min = Math.min(min, scala);
            return;
        }

        for(int i = 0; i < n; i++) {
            if(!listPositive.isEmpty() && i <= listPositive.get(listPositive.size() - 1)) {
                continue;
            }
            bIsPositive[i] = true;
            listPositive.add(i);
            choose(digit + 1);
            bIsPositive[listPositive.remove(listPositive.size() -1)] = false;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();
        for(int p = 0; p < T; p++) {
            n = sc.nextInt();
            points = new Point[n];
            listPositive = new ArrayList<>(n/2);
            bIsPositive = new Boolean[n];
            for(int i = 0; i < n; i++) {
                bIsPositive[i] = false;
            }

            for(int i = 0; i < n; i++) {
                points[i] = new Point(sc.nextInt(), sc.nextInt());
            }
            min = Double.MAX_VALUE;
            choose(0);
            System.out.println(String.format("%.12f", min));
        }
    }
}
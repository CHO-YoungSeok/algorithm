import java.util.*;

class Point {

     int x, y;
     Point(int x, int y) {
          this.x = x;
          this.y = y;
     }
}

public class Main {

     public static void main(String[] args) {
          Scanner sc = new Scanner(System.in);
          int n = sc.nextInt();
          List<Point> points = new ArrayList<>();

          for(int i = 0; i < n; i++) {
               points.add(new Point(sc.nextInt(), sc.nextInt()));
          }

          points.sort((e1, e2) -> {

               if(e1.x == e2.x) {
                    return Integer.valueOf(e1.y).compareTo(Integer.valueOf(e2.y));
               }
               return Integer.valueOf(e1.x).compareTo(Integer.valueOf(e2.x));
          });

          for(int i = 0; i < n; i++) {
               System.out.println(points.get(i).x + " " + points.get(i).y);
          }

     }
}
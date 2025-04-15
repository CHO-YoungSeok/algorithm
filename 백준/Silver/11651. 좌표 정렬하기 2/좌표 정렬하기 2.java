import java.util.*;

public class Main{

     static class Point {
          int x = 0,  y = 0;
          Point (int x, int y){
               this.x = x;
               this.y = y;
          }
          @Override
          public String toString() {
               return x + " " + y;
          }
     }

     public static void main(String[] args) {
          Scanner sc = new Scanner(System.in);
          int n = sc.nextInt();
          List<Point> list = new ArrayList<>();

          for(int i = 0; i < n; i++) {
               list.add(new Point(sc.nextInt(), sc.nextInt()));
          }
          list.sort((e1, e2) -> {
               if(e1.y == e2.y) {
                    return e1.x - e2.x;
               }
               return e1.y - e2.y;
          });
          StringBuilder sb = new StringBuilder();

          for(int i = 0; i < n; i++) {
               sb.append(list.get(i).toString() + "\n");
          }
          System.out.println(sb);
     }
}
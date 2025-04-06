import java.util.*;

class Time {
     int st;
     int end;
     Time(int s, int e) {
          this.st = s;
          this.end = e;
     }
}

public class Main {

     public static void main(String[] args) {
          Scanner sc = new Scanner(System.in);
          int T = sc.nextInt();
          List<Time> times = new ArrayList<>();

          while(0 < T--) {
               int st = sc.nextInt();
               int end = sc.nextInt();
               Time t = new Time(st, end);
               times.add(t);
          }

          times.sort((e1, e2) -> {
               if(e1.end == e2.end) {
                    return e1.st -  e2.st;
               }
               return e1.end -  e2.end;
          });
          int len = times.size();
          int lastEnd = times.get(0).end;
          int count = 1;

          for(int i = 1; i < len; i++) {
               if(lastEnd <= times.get(i).st) {
                    count++;
                    lastEnd = times.get(i).end;
               }
          }

          System.out.println(count);
     }
}

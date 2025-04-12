import java.util.*;
 
public class Main {

     public static void main(String[] args) {
          Scanner sc = new Scanner(System.in);
          StringBuilder sb = new StringBuilder();

          PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
          int t = sc.nextInt();
          while(0 < t--) {
               int dir = sc.nextInt();
               switch(dir) {
               case 0:
                    switch(heap.size()) {
                    case 0:
                         sb.append(0 + "\n");
                         break;
                    default:
                         sb.append(heap.poll() + "\n");
                    }
               default:
                    heap.add(dir);
               }
          }
          System.out.println(sb);
     }
}
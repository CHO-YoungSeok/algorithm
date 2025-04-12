import java.util.*;

public class Main{

     static int[] heap = new int[100001];
     static int size = 0;
     static StringBuilder sb = new StringBuilder();

     static void re() {

          switch(size) {
          case 0:
               sb.append(0 + "\n");
               break;
          default:
               sb.append(heap[1] + "\n");
               int a = heap[size--];
               int index = 1;
               while((index * 2 <= size && a < heap[index * 2]) || (index * 2 + 1 <= size && a < heap[index * 2 + 1])) {
                    if(index * 2 + 1 <= size && heap[index * 2] < heap[index * 2 + 1]) {
                         heap[index] = heap[index * 2 + 1];
                         index = index * 2 + 1;
                    } else {
                         heap[index] = heap[index * 2];
                         index *= 2;
                    }
               }
               heap[index] = a;
          }

     }
     static void add(int a) {
          int index = ++size;
          while(1 < index && heap[index/2] < a) {
               heap[index] = heap[index/2];
               index /= 2;
          }
          heap[index] = a;
     }

     public static void main(String[] args) {
          Scanner sc = new Scanner(System.in);
          int t = sc.nextInt();

          while(0 < t--) {
               int dir = sc.nextInt();
               switch(dir) {
               case 0:
                    re();
                    break;
               default :
                    add(dir);
               }
          }

          System.out.println(sb);
     }
}
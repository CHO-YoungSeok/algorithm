import java.util.*;

public class Main{

     static StringBuilder sb = new StringBuilder();
     static int size = 0;

     static void hRemove(int[] heap) {
          if(size == 0) {
               sb.append(0 + "\n");
               return;  
          }

          sb.append(heap[1] + "\n");
          int a = heap[size--];
          int cI = 1;
          while((cI * 2 <= size && (heap[cI * 2] < a) || (cI*2 + 1 <= size && heap[cI*2 + 1] < a))) {
               if(cI * 2 + 1 <= size && (heap[cI*2] > heap[cI*2 +1])) {
                    heap[cI] = heap[cI * 2 + 1];
                    cI = cI * 2 + 1;
               } else {  
                    heap[cI] = heap[cI*2];
                    cI = cI * 2;
               }
          }
          heap[cI] = a;
     }

     static void hAdd(int[] heap, int a) {
          int cI = ++size;
          while(1 < cI && a < heap[cI/2]) {
               heap[cI] = heap[cI/2];
               cI /= 2;
          }
          heap[cI] = a;
     }

     public static void main(String[] args) {
          Scanner sc = new Scanner(System.in);
          int[] heap = new int[100001];

          int t = sc.nextInt();
          while(0 < t--) {
               int dir = sc.nextInt();
               if(dir == 0) {
                    hRemove(heap);
               } else {
                    hAdd(heap, dir);
                    /*for(int i = 1; i < size; i++)
                         System.out.print(heap[i] + " ");
                    System.out.println();*/
               }
          }
          System.out.println(sb);
     }
}
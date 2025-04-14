import java.util.*;

public class Main {
     public static void main(String[] args) {
          Scanner sc = new Scanner(System.in);
          int n = sc.nextInt();
          int[] nn = new int[n];
          for(int i = 0; i < n; i++) {
               nn[i] = sc.nextInt();
          }
          Arrays.sort(nn);
          StringBuilder sb = new StringBuilder();

          int m = sc.nextInt();
          while(0 < m--) {
               int key = sc.nextInt();
               int lower = 0, upper = 0;

               int low = 0, high = n;
               while(low < high) {
                    int mid = low + (high - low) / 2;
                    if(nn[mid] > key) {
                         high = mid;
                    } else {
                         low = mid + 1;
                    }
               }
               upper = low - 1;

               low = 0;
               high = n;
               while(low < high) {
                    int mid = low + (high - low) / 2;
                    if(nn[mid] >= key) {
                         high = mid;
                    } else {
                         low = mid + 1;
                    }
               }
               lower = low - 1;

               if(lower == upper) {
                    sb.append(0 + " ");
               } else {
                    sb.append(1 + " ");
               }
          }
          System.out.print(sb);
     }
}
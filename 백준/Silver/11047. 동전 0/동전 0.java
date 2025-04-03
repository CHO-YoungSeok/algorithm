import java.util.*;

public class Main {


     public static void main(String[] args) {
          Scanner sc = new Scanner(System.in);
          int n = sc.nextInt();
          int k = sc.nextInt();

          int[] coins = new int[n];
          for(int i = 0; i < n; i++) {
               coins[i] = sc.nextInt();
          }
          int remain = k;
          int count = 0;
          for(int i = n-1; 0<= i; i--) {
               count += remain/coins[i];
               remain = remain % coins[i];
          }
          System.out.println(count);
          
     }
}
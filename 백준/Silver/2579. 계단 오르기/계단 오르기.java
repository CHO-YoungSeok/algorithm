import java.util.*;

public class Main {

     public static void main(String[] args) {
          Scanner sc = new Scanner(System.in);
          int n = sc.nextInt();
          int[] stairs = new int[n];
          for(int i = 0; i < n; i++) {
               stairs[i] = sc.nextInt();
          }

          if(n == 1) {
               System.out.println(stairs[0]);
               System.exit(0); 
          } else if(n == 2) {
               System.out.println(stairs[1] + stairs[0]);
               System.exit(0); 
          }

          int pps1, pps2;
          int ps1, ps2;
          pps1 = stairs[0];
          pps2 = stairs[0];
          ps1 = stairs[1];
          ps2 = pps1 + stairs[1];
          int cs1 = 0;
          int cs2 = 0;

          for(int i = 2; i < n; i++) {
               cs1 = Math.max(pps1, pps2) + stairs[i];
               cs2 = ps1 + stairs[i];
               pps1 = ps1;
               pps2 = ps2;
               ps1 = cs1;
               ps2 = cs2;
          }

          System.out.println(Math.max(cs1, cs2));
     }
}

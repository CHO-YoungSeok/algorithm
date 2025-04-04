import java.util.*;

public class Main {

     static int cnt = 0;

     static void dp(int num) {
          if(num == 0) {
               cnt++;
               return;
          }

          for(int i = 1; i <= 3; i++) {
               if(num >= i) {
                    dp(num - i);
               }
          }
     }
     public static void main(String[] args) {
          Scanner sc = new Scanner(System.in);
          int T = sc.nextInt();
          for(int i = 0; i < T; i++) {
               cnt = 0;
               int num = sc.nextInt();
               dp(num);
               System.out.println(cnt);
          }          
     }
}
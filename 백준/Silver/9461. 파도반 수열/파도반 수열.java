import java.util.*;

public class Main {

     public static void main(String[] args) {
          Scanner sc = new Scanner(System.in);

          long[] p = new long[100];
          p[0] = 1;
          p[1] = 1;
          p[2] = 1;
          p[3] = 2;
          p[4] = 2;
          for(int i = 5; i <100; i++) {
               p[i] = p[i-1] + p[i-5];
          }


          int t= sc.nextInt();
          for(int i = 0; i < t; i++) {
               int n = sc.nextInt();
               System.out.println(p[n -1]);
          }


          
          
     }
}

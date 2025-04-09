import java.util.*;

public class Main {

     public static void main(String[] args) {
          Scanner sc = new Scanner(System.in);
          int n  = sc.nextInt();
          String sixs = "666";
          int count = 1;
          int num = 666;
          while(count < n) {
               num++;
               if(String.valueOf(num).contains(sixs)) {
                    count++;
               }
          }
          System.out.println(num);
          
     }
}


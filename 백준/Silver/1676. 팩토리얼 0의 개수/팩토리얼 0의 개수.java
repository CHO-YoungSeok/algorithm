import java.util.*;

public class Main {

     public static void main(String[] args) {
          Scanner sc = new Scanner(System.in);

          int num = sc.nextInt();
          int countTwo = 0;
          int countFive = 0;

          for(int i = 1; i < num + 1; i++) {
               if(i % 2 == 0) {
                    int j = i;
                    while(j % 2 == 0) {
                         countTwo++;
                         j /= 2;
                    }
               }
               if(i % 5 == 0){
                    int j = i;
                    while(j % 5 == 0) {
                         countFive++;
                         j /= 5;
                    }
               }
          }

          int result = Math.min(countTwo, countFive);
     
          System.out.println(result);
          
     }
}
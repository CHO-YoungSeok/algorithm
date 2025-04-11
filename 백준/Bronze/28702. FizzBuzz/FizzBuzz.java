import java.util.*;

public class Main{

     public static void main(String[] args) {
          Scanner sc = new Scanner(System.in);

          String[] input = new String[3];
          for(int i = 0; i < 3; i++) {
               input[i] = sc.next();
          }
          boolean[] bisNumber  = new boolean[3];
          int count = 0;
          for(int i = 0; i < 3; i++) {
               char c = input[i].charAt(0);
               for(int j = 0; j < 10; j++) {
                    if(c == '1' + j) {
                         bisNumber[i] = true;
                         count = i;
                         break;
                    }
               }
          }
          int num = Integer.parseInt(input[count]);
          int next = num + 3 - count;
          String result = "";
          if(next % 3 == 0) {
               result += "Fizz";
          }
          if(next % 5 == 0) {
               result += "Buzz";
          }
          if(next % 5 != 0 && next % 3 != 0){
               result = "" + next;
          }
          System.out.println(result);



     }
}
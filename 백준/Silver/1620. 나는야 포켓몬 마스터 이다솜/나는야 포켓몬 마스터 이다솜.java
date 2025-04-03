import java.util.*;

public class Main {


     public static void main(String[] args) {
          Scanner sc = new Scanner(System.in);
          int n = sc.nextInt();
          int m = sc.nextInt();

          HashMap<String, Integer> nameMap = new HashMap<>();
          HashMap<Integer, String> numMap = new HashMap<>();
          for(int i = 1; i <= n; i++) {
               String name = sc.next();
               nameMap.put(name, i);
               numMap.put(i, name);
          }
          for(int i = 0; i < m; i++) {
               String q = sc.next();
               char c = q.charAt(0);
               boolean bIsNum = false;
               int one = '1';
               for(int j = 0; j < 9; j++) {
                    if(c == one + j) {
                         bIsNum = true;
                         break;
                    }
               }
               if(bIsNum) {
                    System.out.println(numMap.get(Integer.parseInt(q)));
               } else {
                    System.out.println(nameMap.get(q));
               }

          }
     }
}
import java.util.*;

public class Main {

     public static void main(String[] args) {
          Scanner sc = new Scanner(System.in);
          int n = sc.nextInt();
          List<String> list = new ArrayList<>();
          for(int i = 0; i < n; i++) {
               list.add(sc.next());
          }

          list.sort((e1, e2) -> {
               if(e1.length() == e2.length()) {
                    return e1.compareTo(e2);
               } else {
                    return e1.length() - e2.length();
               }
          });

          for(int i = 0; i < n; i++) {
               if(0 < i && list.get(i).equals(list.get(i-1))) {
                    continue;
               }
               System.out.println(list.get(i));
          }
     }
}

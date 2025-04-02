import java.util.*;

public class Main {
     public static void main(String[] args) {
          Scanner sc = new Scanner(System.in);
          int T = sc.nextInt();
          while(0 < T--) {
               HashMap<String, Integer> map = new HashMap<>();
               ArrayList<String> list = new ArrayList<>();
               int t = sc.nextInt();
               while(0 < t--) {
                    String name = sc.next();
                    String product = sc.next();

                    if(map.containsKey(product)) {
                         int c = map.get(product);
                         map.remove(product);
                         map.put(product, c + 1);
                    } else {
                         list.add(product);
                         map.put(product, 1);
                    }
               }
               int result = 1;
               int size = map.size();
               if(size != list.size()){
                    System.exit(2);
               }
               for(int i = 0; i < size; i++) {
                    String p = list.get(i);
                    result *= map.get(p) + 1;
               }
               System.out.println(result -1);
          } 
     }
}
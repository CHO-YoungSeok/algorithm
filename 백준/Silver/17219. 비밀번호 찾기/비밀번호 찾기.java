    import java.util.*;

    public class Main {

    public static void main(String[] args) {
	   Scanner sc = new Scanner(System.in);
       int m = sc.nextInt(), n = sc.nextInt();

       HashMap<String, String> map = new HashMap<>();
       for(int i = 0; i < m; i++) {
            String site = sc.next();
            String pass = sc.next();
            map.put(site, pass);
       }

       StringBuffer bf = new StringBuffer();

       for(int i = 0; i < n; i++) {
            String site = sc.next();
            bf.append(map.get(site) + "\n");
       }

       System.out.println(bf.toString());


    }
}


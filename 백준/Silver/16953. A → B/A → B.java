import java.util.*;

class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();

        Queue<Integer> q = new LinkedList<>();
        HashSet<Integer> set = new HashSet<>();
        q.offer(a);

        int result = 1;
        while (!q.isEmpty()) {
            result++;

            int t = q.size();
            while (0 < t--) {
                int n = q.poll();
                if (set.contains(n)) {
                    continue;
                } 
              
                set.add(n);  

                long k  = n * 10L + 1;
                // System.out.print(k + " ");
                if (k < b) {
                    q.add((int)k);
                } else if (k == b) {
                    System.out.println(result);
                    System.exit(0);
                } else {}

                k = n * 2L;
                // System.out.println(k);
                if (k < b) {
                    q.add((int)k);
                } else if (k == b) {
                    System.out.println(result);
                    System.exit(0);
                } else {}
            }
        }

        System.out.println(-1);
        
    }
}
import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int T, n, k, w;
    static int[] times;
    static int[] degree;
    static int[] resultTimes;

    static LinkedList<Integer>[] list;

    public static void main(String[] args) {
        T = sc.nextInt();
        for(int p = 0; p < T; p++) {
            n = sc.nextInt();
            k = sc.nextInt();
            times = new int[n];
            for(int i = 0; i < n; i++) {
                times[i] = sc.nextInt();
            }
            list = new LinkedList[n];
            for(int i = 0;  i < n; i++) {
                list[i] = new LinkedList<>();
            }
            degree = new int[n];
            for(int i = 0; i < k; i++) {
                int from = sc.nextInt() -1;
                int to = sc.nextInt() -1;
                list[from].add(to);
                degree[to]++;
            }
            w = sc.nextInt();


            Queue<Integer> q= new LinkedList<>();
            resultTimes = new int[n];
            for(int i = 0; i < n; i++) {
                if(degree[i] == 0) {
                    resultTimes[i] = times[i];
                    q.offer(i);
                }
            }
            while(!q.isEmpty()) {
                int cur = q.poll();
                while (!list[cur].isEmpty()) {
                    int next = list[cur].poll();
                    degree[next]--;
                    resultTimes[next] = Math.max(resultTimes[next], resultTimes[cur] + times[next]);
                    if (degree[next] == 0) {
                        q.offer(next);
                    }
                }
            }
            System.out.println(resultTimes[w-1]);
        }
    }
}
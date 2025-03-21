import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int t, n, k, w;
    static int[] times, indegree, result;
    static List<Integer>[] list;

    public static void main(String[] args) {
        t = sc.nextInt();
        for (int p = 0; p < t; p++) {
            n = sc.nextInt();
            k = sc.nextInt();
            times = new int[n + 1];
            indegree = new int[n + 1];
            result = new int[n + 1];
            list = new LinkedList[n + 1];

            for (int i = 1; i <= n; i++) {
                times[i] = sc.nextInt();
                list[i] = new LinkedList<>();
            }

            for (int i = 0; i < k; i++) {
                int from = sc.nextInt();
                int to = sc.nextInt();
                list[from].add(to);
                indegree[to]++;
            }

            w = sc.nextInt();
            System.out.println(topologicalSort());
        }
    }

    static int topologicalSort() {
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            result[i] = times[i];
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        while (!q.isEmpty()) {
            int current = q.poll();
            for (int next : list[current]) {
                result[next] = Math.max(result[next], result[current] + times[next]);
                if (--indegree[next] == 0) {
                    q.offer(next);
                }
            }
        }
        return result[w];
    }
}
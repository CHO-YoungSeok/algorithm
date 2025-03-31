    import java.util.*;

    public class Main {

        static boolean[] visited;

        static void dfs(boolean[][] graph, int node) {
            System.out.print(node + 1 + " ");
            int n = graph[0].length;

            for(int i = 0; i < n; i++) {
                if(!visited[i] && graph[node][i]) {
                    visited[i] = true;
                    dfs(graph, i);
                }
            }
        }

        static void bfs(boolean[][] graph, int node) {
            Queue<Integer> q = new LinkedList<>();
            q.add(node);
            int n = graph[0].length;

            while(q.peek() != null) {
                int recentNode = q.poll();
                System.out.print(recentNode + 1 + " ");
                for(int i = 0; i < n; i++){
                    if(!visited[i] && graph[recentNode][i]) {
                        visited[i] = true;
                        q.add(i);
                    }
                }
            }
        }

        public static void main(String[] args) {
        	Scanner sc = new Scanner(System.in);

        	int n = sc.nextInt();
            int m = sc.nextInt();
            int v = sc.nextInt();

            boolean[][] graph = new boolean[n][n];
            visited = new boolean[n];

            for(int i = 0; i < m; i++) {
                int n1 = sc.nextInt();
                int n2 = sc.nextInt();
                graph[n1 -1][n2 -1] = true;
                graph[n2 -1][n1 -1] = true;
            }
            Arrays.fill(visited, false);
            visited[v-1] = true;
            dfs(graph, v-1);
            System.out.println();
            Arrays.fill(visited, false);
            visited[v-1] = true;
            bfs(graph, v-1);        

        }
    }


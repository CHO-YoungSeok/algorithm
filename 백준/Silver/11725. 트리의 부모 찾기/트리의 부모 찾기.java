import java.util.*;
import java.io.*;

class Main {

    static int[] result;
    static boolean[] visited;
    static ArrayList<LinkedList<Integer>> graph;

    static void dfs(int node) {

        for (int connectedNode : graph.get(node)) {
            if (!visited[connectedNode]) {
                visited[connectedNode] = true;
                result[connectedNode] = node;
                dfs(connectedNode);
            }
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        graph = new ArrayList<>(n + 1);

        for (int  i = 0; i <= n; i++) {
            LinkedList<Integer> list = new LinkedList<>();
            graph.add(list);
        }

        result = new int[n + 1];
        visited = new boolean[n + 1];
        for (int i = 2; i <= n; i++) {
            String[] ins = br.readLine().split(" ");
            int n1 = Integer.parseInt(ins[0]);
            int n2 = Integer.parseInt(ins[1]);
            graph.get(n1).add(n2);
            graph.get(n2).add(n1);
        }

        visited[1] = true;
        dfs(1);
        for (int i = 2; i <= n; i++) { 
            sb.append(result[i]).append('\n');
        }
        System.out.println(sb);
    }
}
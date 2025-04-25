import java.util.*;
import java.io.*;

public class Main {

    static int[][] graph;
    static boolean[] bisVisited;
    static int count = 0;
    static void bfs(int node) {
        bisVisited[node] = true;
        Queue<Integer> q = new LinkedList<>();
        q.offer(node);
        while(!q.isEmpty()) {
            int curr = q.poll();
            for(int i = 0; i < graph[0].length; i++) {
                if(graph[curr][i] == 1 && !bisVisited[i]) {
                    bisVisited[i] = true;
                    q.offer(i);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputs = br.readLine().split(" ");
        int n = Integer.parseInt(inputs[0]);
        int m = Integer.parseInt(inputs[1]);
        graph = new int[n][n];
        bisVisited = new boolean[n];

        for(int i = 0; i < m; i++) {
            inputs = br.readLine().split(" ");
            int st = Integer.parseInt(inputs[0]) - 1;
            int ed = Integer.parseInt(inputs[1]) - 1;
            graph[st][ed] = 1;
            graph[ed][st] = 1;
        }

        for(int i = 0; i < n; i++) {
            if(!bisVisited[i]) {
                count++;
                bfs(i);
            }
        }

        System.out.println(count);

    }
}
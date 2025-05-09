import java.util.*;
import java.io.*;

class Point {
    int x, y;
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] ins1 = br.readLine().split(" ");
        int n = Integer.parseInt(ins1[0]);
        int m = Integer.parseInt(ins1[1]);
        int[][] arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            String ins2 = br.readLine();
            for(int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt("" + ins2.charAt(j));
            }
        }

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        Queue<Point> que = new LinkedList<>();
        que.add(new Point(0, 0));
        int result = 1;
        boolean[][] visited = new boolean[n][m];
        visited[0][0] = true;
        while (!que.isEmpty() && !visited[n-1][m-1]) {
            int size = que.size();
            while (0 < size--) {
                Point quePoint = que.poll();
                int x = quePoint.x;
                int y = quePoint.y;

                for (int i = 0; i < 4; i++) {
                    int xx = x + dx[i];
                    int yy = y + dy[i];
                    if (0 <= xx && xx < n && 0 <= yy && yy < m && !visited[xx][yy] && arr[xx][yy] == 1) {
                        visited[xx][yy] = true;
                        que.offer(new Point(xx, yy));
                    }
                }
            }
            result++;
        }

        System.out.println(result);


    }
}

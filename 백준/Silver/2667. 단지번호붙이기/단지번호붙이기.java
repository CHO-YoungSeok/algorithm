import java.util.*;
import java.io.*;

class Group {
    int name = 0, count = 0;
    Group(int name, int count) {
        this.name = name;
        this.count = count;
    }
}

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

        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            String ins = br.readLine();
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(ins.charAt(j) + "");
            }
        }

        boolean[][] visited = new boolean[n][n];
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        List<Group> groupList = new ArrayList<>();
        Queue<Point> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j] || arr[i][j] == 0) {
                    continue;
                }
                visited[i][j] = true;
                q.offer(new Point(i, j));
                groupList.add(new Group(groupList.size() + 1, 1));
                
                while (!q.isEmpty()) {
                    Point quePoint = q.poll();
                    int x = quePoint.x;
                    int y = quePoint.y;

                    for (int t = 0; t < 4; t++) {
                        int xx = x + dx[t];
                        int yy = y + dy[t];
                        if (0 <= xx && xx < n && 0 <= yy && yy < n && !visited[xx][yy] && arr[xx][yy] == 1) {
                            visited[xx][yy] = true;
                            groupList.get(groupList.size() - 1).count++;
                            q.offer(new Point(xx, yy));
                        }
                    }
                }
            }
        }


        groupList.sort((e1, e2) -> e1.count - e2.count);
        sb.append(groupList.size() + "\n");
        for (int  i = 0; i < groupList.size(); i++) {
            sb.append(groupList.get(i).count + "\n");
        }
        System.out.print(sb);
    }
}
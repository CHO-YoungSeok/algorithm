import java.util.*;

class Point {
     int x;
     int y;
     Point(int x, int y) {
          this.x = x;
          this.y = y;
     }
}

public class Main {

     public static void main(String[] args) {
          Scanner sc = new Scanner(System.in);
          int n = sc.nextInt();
          int m = sc.nextInt();
          int[][] field = new int[n][m];
          boolean[][] visited = new boolean[n][m];
          int px = 0, py = 0;
          for(int i = 0; i < n; i++) {
               for(int j = 0; j < m; j++) {
                    field[i][j] = sc.nextInt();
                    visited[i][j] = false;
                    if(field[i][j] == 2){
                         px = i;
                         py = j;
                    }
               }
          }

          int[] dx = {1, 0, -1, 0};
          int[] dy = {0, 1, 0, -1};
          int[][] dis = new int[n][m];
          visited[px][py] = true;
          dis[px][py] = 0;
          Queue<Point> q = new LinkedList<>();
          
          Point p = new Point(px, py);
          q.add(p);

          while(!q.isEmpty()) {
               Point currentP = q.poll();
               for(int i = 0; i < 4; i++) {
                    int cx = currentP.x + dx[i];
                    int cy = currentP.y + dy[i];
                    if(0 > cx || n <= cx || 0 > cy || m <= cy || field[cx][cy] == 0 || visited[cx][cy]) {
                         continue;
                    }

                    visited[cx][cy] = true;
                    dis[cx][cy] = dis[currentP.x][currentP.y] + 1;
                    Point fp = new Point(cx, cy);
                    q.add(fp);
               }
          }


          StringBuffer sb = new StringBuffer();
          for(int i = 0; i < n; i++) {
               for(int j = 0; j < m; j++) {
                    if(dis[i][j] == 0 && field[i][j] == 1) {
                         dis[i][j] = -1;
                    }
                    sb.append(Integer.toString(dis[i][j]) + " ");
               }
               sb.append("\n");
          }

          System.out.print(sb);
     }
}

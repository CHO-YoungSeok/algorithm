import java.util.*;



public class Main {

     public static void main(String[] args) {
          Scanner sc = new Scanner(System.in);
          int m = sc.nextInt();
          int n = sc.nextInt();
          int[][] field =  new int[n][m];
          int pre = 0;
          Queue<Integer> qX = new LinkedList<>();
          Queue<Integer> qY = new LinkedList<>();
          boolean[][] visited = new boolean[n][m];

          for(int i = 0; i < n; i++) {
               for(int j = 0; j < m; j++) {
                    field[i][j] = sc.nextInt();
                    if(field[i][j] == 0) {
                         pre++;
                    } else if(field[i][j] == 1) {
                         visited[i][j] = true;
                         qX.offer(i);
                         qY.offer(j);
                    }
               }
          }

          int[] dx = {-1, 0, 1, 0};
          int[] dy = {0, 1, 0, -1};
          int result = 0;
          while(!qX.isEmpty()) {
               int  t = qX.size();
               while(0 < t--) {
                    int cx = qX.poll();
                    int cy = qY.poll();
                    for(int i = 0; i < 4; i++) {
                         int xx = cx + dx[i];
                         int yy = cy + dy[i];
                         if(xx < 0 || n <= xx || yy < 0 || m <= yy || field[xx][yy] == -1 || visited[xx][yy]) {
                              continue;
                         }

                         visited[xx][yy] = true;
                         pre--;
                         qX.offer(xx);
                         qY.offer(yy);
                    }
               }
               result++;
          }

          if(0 < pre) {
               System.out.println(-1);
          } else {
               System.out.println(result - 1);
          }


          
     }
}

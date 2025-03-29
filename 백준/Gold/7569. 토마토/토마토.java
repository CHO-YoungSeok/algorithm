import java.util.*;

class Point {
	int h, m, n;
	int level;
	Point(int h, int n, int m, int level) {
		this.h = h;
		this.n = n;
		this.m = m;
		this.level = level;
	}
}

public class Main {

    public static void main(String[] args) {
    	int m, n, h;
    	Scanner sc = new Scanner(System.in);
    	m = sc.nextInt();
    	n = sc.nextInt();
    	h = sc.nextInt();
    	int[][][] field = new int[h][n][m];
    	boolean[][][] bIsVisited = new boolean[h][n][m];
    	Queue<Point> q = new LinkedList<>();
    	int prematual = 0;

    	for(int k = 0;  k < h; k++) {
	    	for(int i = 0; i < n; i++) {
	    		for(int j = 0;  j < m; j++) {
	    			bIsVisited[k][i][j] = false;
	    			field[k][i][j] = sc.nextInt();

	    			if(field[k][i][j] == 0) {
	    				prematual++;
	    			} else if(field[k][i][j] == 1) {
	    				bIsVisited[k][i][j] = true;
	    				Point p = new Point(k,i,j, 0);
	    				q.offer(p);
	    			} 
	    		}
    		}
		}

    	int[] dh = {1, -1, 0, 0, 0, 0};
    	int[] dn = {0, 0, 0, 0, 1, -1};
    	int[] dm = {0, 0, 1, -1, 0, 0};

    	int maxLevel = 0;
		while(!q.isEmpty()) {
			Point rP = q.poll();
			maxLevel = Math.max(maxLevel, rP.level);
			for(int i = 0; i < 6; i++) {
				int rH = rP.h + dh[i];
				int rN = rP.n + dn[i];
				int rM = rP.m + dm[i];
				
				if(rH < 0 || h <= rH || rM < 0 || m <= rM || rN < 0 || n <= rN || bIsVisited[rH][rN][rM]) {
					continue;
				}

				if(field[rH][rN][rM] == 0) { 
					field[rH][rN][rM] = 1;
					bIsVisited[rH][rN][rM] = true;
					prematual--;
					q.offer(new Point(rH, rN, rM, rP.level + 1));
				}
			}
		}

		if(0 <= maxLevel && prematual == 0) {
			System.out.println(maxLevel);
		} else {
			System.out.println(-1);
		}
    }
}
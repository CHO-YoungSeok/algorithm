import java.util.*;

class Point {
    int x, y;
    Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}

class Solution {
    public int solution(String[] storage, String[] requests) {
        int answer = 0;
        boolean[][] bisEdge = new boolean[storage.length][storage[0].length()];
        
        for (int r = 0; r < storage.length; r++) {
            bisEdge[r][0] = true;
            bisEdge[r][storage[0].length() - 1] = true;
        }
        for (int c = 0; c < storage[0].length(); c++) {
            bisEdge[0][c] = true;
            bisEdge[storage.length - 1][c] = true;
        }
        
        char[][] map = new char[storage.length][storage[0].length()];
        
        Queue<Point> buffer = new LinkedList<>();
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        for (String direction : requests) {
            char dir = direction.charAt(0);
            
            if (direction.length() == 1) {
                for (int r = 0; r < storage.length; r++) {
                    for (int c = 0; c < storage[0].length(); c++) {
                        if (
                            bisEdge[r][c] &&
                            storage[r].charAt(c) == dir
                        ) {
                            buffer.offer(new Point(r, c));
                        }
                    }
                }
            } else {
                for (int r = 0; r < storage.length; r++) {
                    for (int c = 0; c < storage[0].length(); c++) {
                        if (
                            storage[r].charAt(c) == dir
                        ) {
                            buffer.offer(new Point(r, c));
                        }
                    }
                }
            }
            
            while (!buffer.isEmpty()) {
                Point p = buffer.poll();
                map[p.x][p.y] = '-';
                    
                for (int d = 0; d < 4; d++) {
                    int xx = p.x + dx[d];
                    int yy = p.y + dy[d];
                    if (
                        bisEdge[p.x][p.y] &&
                        xx >= 0 &&
                        xx < storage.length &&
                        yy >= 0 && 
                        yy < storage[0].length() &&
                        !bisEdge[xx][yy]
                    ) {
                        bisEdge[xx][yy] = true;
                        
                        if (map[xx][yy] == '-') {
                            buffer.offer(new Point(xx, yy));
                        }
                    }
                }
            }
        }
        int result = 0;
        for (int r = 0; r < storage.length; r++) {
            for (int c = 0; c < storage[0].length(); c++) {
                System.out.print(map[r][c] + " ");
                if (map[r][c] == '-') {
                    continue;
                }
                
                result++;
            }
            System.out.println();
        }
        answer = result;
        return answer;
    }
}
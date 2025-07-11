class Solution {
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        
        int n = board.length;
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        int count = 0;
        for (int i = 0; i < 4; i++) {
            int xx = h + dx[i];
            int yy = w + dy[i];
            if (
                0 <= xx && xx < n
                && 0 <= yy && yy < n
            ) {
                if (board[xx][yy].equals(board[h][w])) {
                    count++;
                }
            }
        }
        answer = count;
        return answer;
    }
}
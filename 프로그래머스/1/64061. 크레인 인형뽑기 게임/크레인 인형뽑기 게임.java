import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        
        List<Integer> list = new ArrayList<>();
        for (int m : moves) {
            int c = m - 1;
            int r = 0;
            if (board[board.length - 1][c] == 0) {
                continue;
            }
            for (r = 0; r < board.length; r++) {
                if (board[r][c] != 0) {
                    break;
                }
            }
            
            list.add(board[r][c]);
            board[r][c] = 0;
            
            if (
                list.size() > 1 && 
                list.get(list.size() - 1) == list.get(list.size() - 2)
            ) {
                answer += 2;
                list.remove(list.size() - 1);
                list.remove(list.size() - 1);
            } 
        }
        return answer;
    }
}
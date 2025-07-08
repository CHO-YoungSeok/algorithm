import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        
        for (int dir : moves) {
            int c = dir - 1;
            if (board[board.length - 1][c] == 0) {
                continue;
            }
            
            int r = 0;
            while (board[r][c] == 0) {
                r++;
            }
            
            if (
                stack.peek() != null &&
                stack.peek() == board[r][c]
            ) {
                answer += 2;
                stack.pop();
                System.out.println(answer + ": " + board[r][c] + 
                                   " r=" + r + " c=" + c);
            } else {
                stack.push(board[r][c]);
            }
            
            board[r][c] = 0;           
            
        }
        
        
        return answer;
    }
}
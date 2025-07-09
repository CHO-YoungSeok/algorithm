import java.util.*;

class Move {
    int from, to;
    
    Move(int from, int to) {
        this.from = from;
        this.to = to;
    }
}

class Solution {
    static List<Move> moves = new ArrayList<>();

    void move(int count, int from, int to, int temp) {
        if (count == 1) {
            moves.add(new Move(from, to));
            return;
        }
        
        move(count - 1, from, temp, to);
        move(1, from, to, temp);
        move(count - 1, temp, to, from);
    }
    public int[][] solution(int n) {
        move(n, 1, 3, 2);
        int[][] answer = new int[moves.size()][2];
        
        for (int i = 0; i < moves.size(); i++) {
            answer[i][0] = moves.get(i).from;
            answer[i][1] = moves.get(i).to;
        }
        return answer;
    }
}
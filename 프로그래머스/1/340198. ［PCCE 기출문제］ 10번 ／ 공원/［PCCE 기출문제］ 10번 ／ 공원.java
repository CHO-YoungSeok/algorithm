import java.util.*;

class Solution {
    int getRectSize(String[][] park, int x, int y, int k) {
        if (x + k >= park.length || y + k >= park[0].length) {
            return k;
        }
        for (int i = 0; i <= k; i++) {
            if (!park[x + k][y + i].equals("-1") || !park[x + i][y + k].equals("-1")) {
                return k;
            }
        }
        return getRectSize(park, x, y, k + 1);
    }
    
    public int solution(int[] mats, String[][] park) {
        int answer = -1;
        int max = 0;
        for (int i = 0; i < park.length; i++) {
            for (int j = 0; j < park[0].length; j++) {
                if (park[i][j].equals("-1")) {
                    max = Math.max(max, getRectSize(park, i, j, 1));
                }
            }
        }
        System.out.println(max);
        
        Arrays.sort(mats);
        for (int i = mats.length - 1; 0 <= i; i--) {
            if (mats[i] <= max) {
                answer = mats[i];
                break;                
            }
        }
        
        return answer;
    }
}
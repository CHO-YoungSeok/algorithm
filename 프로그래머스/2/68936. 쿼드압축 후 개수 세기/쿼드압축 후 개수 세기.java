class Solution {
    int count0, count1;
    
    void division(int[][] arr, int r, int c, int n, int m) {
        boolean isSame = true;
        for (int i = r; i < n && isSame; i++) {
            for (int j = c; j < m; j++) {
                if (arr[r][c] != arr[i][j]) {
                    isSame = false;
                    break;
                }
            }
        }
        
        if (isSame) {
            if (arr[r][c] == 0) count0++;
            else count1++;
        } else {
            int half = (n - r) / 2;
            int halfR = r + half;
            int halfC = c + half;
            division(arr, r, c, halfR, halfC);
            division(arr, r, halfC, halfR, m);
            division(arr, halfR, c, n, halfC);
            division(arr, halfR, halfC, n, m);
        }
    }
    
    public int[] solution(int[][] arr) {
        count0 = 0; 
        count1 = 0;
        
        division(arr, 0, 0, arr.length, arr.length);
        int[] answer = {count0, count1};
        return answer;
    }
}

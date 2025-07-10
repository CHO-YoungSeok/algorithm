class Solution {
    
    static int size;
    
    void division(int[][] arr, int r, int c, int n, int m) {
            
        for (int i = r; i < n; i++) {
            for (int j = c; j < m; j++) {
                if (arr[r][c] != arr[i][j]) {
                    int half = (n - r) / 2;
                    System.out.println(half);
                    division(arr, r, c, r + half, c + half);
                    division(arr, r, c + half, r + half, m);
                    division(arr, r + half, c, n, c + half);
                    division(arr, r + half, c + half, n, m);
                    return;
                }
            }
        }
        
        int temp = arr[r][c];
        for (int i = r; i < n; i++) {
            for (int j = c; j < m; j++) {
                arr[i][j] = -1;
            }
        }
        
        arr[r][c] = temp;
    }
    
    public int[] solution(int[][] arr) {
        size = arr.length;
        division(arr, 0, 0, size, size);
        int count0 = 0, count1 = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                switch (arr[i][j]) {
                    case 0:
                        count0++;
                        break;
                    case 1:
                        count1++;
                        break;
                    default:
                }
            }
        }
        
        int[] answer = {count0, count1};
        return answer;
    }
}
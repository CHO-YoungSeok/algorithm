class Solution {
    public int solution(int n, int w, int num) {
        int answer = 0;
        
        int boxH = (num % w == 0) ? (num / w) : ((num / w) + 1);
        int boxW = 0;
    
        if (num % (2 * w) > w || num % (2 * w) == 0) {
            boxW = (num % w == 0) ? 0 : w - (num % w);       
        } else {
            boxW = (num - 1) % w;
        }
        
        int[] hs = new int[w];
        for (int i = 0; i < w; i++) {
            hs[i] = n / w;
        }
        if (n % w != 0) {
            if (n % (2 * w) > w) {
                for (int i = 0; i < n % w; i++) {
                    hs[w - 1 - i]++;
                }
            } else {
                for (int i = 0; i < n % w; i++) {
                    hs[i]++;
                }
            }
        }
        
        answer = hs[boxW] - boxH + 1;    
        
        return answer;
    }
}
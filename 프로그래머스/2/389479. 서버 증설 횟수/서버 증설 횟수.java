class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        int[] servers = new int[24];
        int result = 0;
        
        for (int i = 0; i < 24; i++) {
            if (players[i] < m * (servers[i] + 1)) {
                continue;
            }
            
            int add = (players[i] / m) - servers[i];
            result += add;
            for (int j = 0; j < k && i + j < 24; j++) {
                servers[i + j] += add;
            }
        }
        answer = result;
        return answer;
    }
}